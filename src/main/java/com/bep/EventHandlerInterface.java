package com.bep;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.MessageEvent;

import java.io.IOException;

interface EventHandlerInterface {
    public void handle(EventsApiPayload<MessageEvent> payload, EventContext context) throws IOException, SlackApiException;
}