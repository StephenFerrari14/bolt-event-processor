package com.bep;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.MessageEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class ProcessRunner implements Runnable {
    private ArrayList<EventProcess> _processes;
    private EventsApiPayload<MessageEvent> _payload;
    private EventContext _context;

    public ProcessRunner(ArrayList<EventProcess> processes, EventsApiPayload<MessageEvent> payload, EventContext context) {
        _processes = processes;
        _payload = payload;
        _context = context;
    }

    @Override
    public void run() {
        for (EventProcess process : _processes) {
            Matcher m = process.getPattern().matcher(_payload.getEvent().getText());
            // Still kind of want to pass the matches results to the handler
            boolean matched = m.matches();
            if (matched) {
                System.out.println("Regex matched");
                try {
                    process.runHandler(_payload, _context);
                } catch (IOException | SlackApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
