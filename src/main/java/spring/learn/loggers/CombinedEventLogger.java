package spring.learn.loggers;

import spring.learn.beans.Event;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {

    private final Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        super();
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for (EventLogger eventLoger :
             loggers) {
            eventLoger.logEvent(event);
        }
    }
}
