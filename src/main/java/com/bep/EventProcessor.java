package com.bep;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.bolt.response.Response;
import com.slack.api.model.event.MessageEvent;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class EventProcessor {
    private ArrayList<EventProcess> processes = new ArrayList<>();

    // Configure threads per process? Configure then batch
    private boolean threaded = false;

    public Response process(EventsApiPayload<MessageEvent> payload, EventContext context) {
        // Idk a runner means you can't return so might change it back and thread differently
        ProcessRunner runner = new ProcessRunner(processes, payload, context);
        if (threaded) {
            Thread processThread = new Thread(runner);
            processThread.start();
        } else {
            runner.run();
        }
        return context.ack();
    }

    public void addHandler(String eventString, EventHandler handler) {
        addHandler(Pattern.compile(eventString), handler);
    }

    public void addHandler(Pattern eventPattern, EventHandler handler) {
        EventProcess process = new EventProcess(eventPattern, handler);
        this.processes.add(process);
    }

    public int getHandlerCount() {
        return processes.size();
    }
}
