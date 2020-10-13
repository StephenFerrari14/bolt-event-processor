package com.bep;

import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.MessageEvent;
import org.junit.Test;

import java.io.IOException;

public class EventProcessorTest {

    @Test
    public void testAddHandler() {
        EventProcessor processor = new EventProcessor();
        String eventStr = "test";
        processor.addHandler(eventStr, new EventHandler() {
            @Override
            public void handle(EventsApiPayload<MessageEvent> payload, EventContext context) throws IOException, SlackApiException {
                super.handle(payload, context);
            }
        });

        assert processor.getHandlerCount() == 1;
    }
}
