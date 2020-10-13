package com.bep;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.MessageEvent;

import java.io.IOException;
import java.util.regex.Pattern;

public class EventProcess {

    private Pattern pattern;
    private EventHandler handler;

    public EventProcess(Pattern pattern, EventHandler handler){
        this.pattern = pattern;
        this.handler = handler;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public EventHandler getHandler() {
        return handler;
    }

    public void setHandler(EventHandler handler) {
        this.handler = handler;
    }

    public void runHandler(EventsApiPayload<MessageEvent> payload, EventContext context) throws IOException, SlackApiException {
        handler.handle(payload, context);
    }
}
