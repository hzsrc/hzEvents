package cn.hz.eventSamplee;

import cn.hz.events.*;

public class Subject {
    //Simple event
    Event event1 = new Event();
    //Event with arguments
    Event2<String, Integer> eventWithArg = new Event2<>();

    //Sample of removeListener
    Event3<Subject, Integer, Integer> eventRemoved = new Event3<>();


    public void start() {
        // fire events at the appropriate time
        onEvent1(new EventArgs());
        onEvent2(new EventArgs2<>("Event2", 2));
        onEvent3(new EventArgs3<>(this, 3, 3));
    }

    protected void onEvent1(EventArgs e) {
        if (!event1.isEmpty()) {
            event1.fire(this, e);
        }
    }

    protected void onEvent2(EventArgs2<String, Integer> e) {
        if (!eventWithArg.isEmpty()) {
            eventWithArg.fire(this, e);
        }
    }

    protected void onEvent3(EventArgs3<Subject, Integer, Integer> e) {
        if (!eventRemoved.isEmpty()) {
            eventRemoved.fire(this, e);
        }
    }
}
