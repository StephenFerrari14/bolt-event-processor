# Bolt Event Processor (BEP)
Handle all events from the Bolt Slack app event functionality through pattern matching and event handlers. 
The package is simple but provides a quick and easy plugin to run logic for messages. 
  
  
Written in Java 8
# Example
```$java
App app = new App();
EventProcessor processor = new EventProcessor();

processor.addHandler("test", new EventHandler() {
    @Override
    public void handle(EventsApiPayload<MessageEvent> payload, EventContext context) throws IOException, SlackApiException {
        context.say("Test response");
    }
});

app.event(MessageEvent.class, processor::process);
```