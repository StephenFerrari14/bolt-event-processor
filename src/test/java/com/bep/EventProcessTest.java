package com.bep;

import com.slack.api.app_backend.events.payload.Authorization;
import com.slack.api.app_backend.events.payload.EventsApiPayload;
import com.slack.api.bolt.context.builtin.EventContext;
import com.slack.api.methods.SlackApiException;
import com.slack.api.model.event.MessageEvent;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

public class EventProcessTest {

    @Test
    public void runHandlerTest() {
        Pattern testPattern = Pattern.compile("test");
        EventHandler handler = new EventHandler() {
            @Override
            public void handle(EventsApiPayload<MessageEvent> payload, EventContext context) throws IOException, SlackApiException {
                context.ack();
            }
        };
        EventsApiPayload<MessageEvent> payload = new EventsApiPayload<MessageEvent>() {
            @Override
            public String getToken() {
                return null;
            }

            @Override
            public void setToken(String s) {

            }

            @Override
            public String getTeamId() {
                return null;
            }

            @Override
            public void setTeamId(String s) {

            }

            @Override
            public String getApiAppId() {
                return null;
            }

            @Override
            public void setApiAppId(String s) {

            }

            @Override
            public MessageEvent getEvent() {
                return null;
            }

            @Override
            public void setEvent(MessageEvent messageEvent) {

            }

            @Override
            public String getType() {
                return null;
            }

            @Override
            public void setType(String s) {

            }

            @Override
            public String getEventId() {
                return null;
            }

            @Override
            public void setEventId(String s) {

            }

            @Override
            public Integer getEventTime() {
                return null;
            }

            @Override
            public void setEventTime(Integer integer) {

            }

            @Override
            public String getEventContext() {
                return null;
            }

            @Override
            public void setEventContext(String s) {

            }

            @Override
            public boolean isExtSharedChannel() {
                return false;
            }

            @Override
            public void setExtSharedChannel(boolean b) {

            }

            @Override
            public List<String> getAuthedUsers() {
                return null;
            }

            @Override
            public void setAuthedUsers(List<String> list) {

            }

            @Override
            public List<String> getAuthedTeams() {
                return null;
            }

            @Override
            public void setAuthedTeams(List<String> list) {

            }

            @Override
            public List<Authorization> getAuthorizations() {
                return null;
            }

            @Override
            public void setAuthorizations(List<Authorization> list) {

            }

            @Override
            public String getEnterpriseId() {
                return null;
            }

            @Override
            public void setEnterpriseId(String s) {

            }
        };
        EventContext context = new EventContext();
        EventProcess process = new EventProcess(testPattern, handler);

        try {
            process.runHandler(payload, context);
            assert true;
        } catch (IOException | SlackApiException e) {
            e.printStackTrace();
            assert false;
        }
    }
}
