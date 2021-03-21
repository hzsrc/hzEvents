package cn.hz.eventSamplee;

import cn.hz.events.*;

class Subject {
    Event event1 = new Event();
    Event2<String, Integer> eventWithArg = new Event2<>();

    Event3<Subject, Integer, Integer> eventRemoved = new Event3<>();


    public void start() {
        event1.fire(this, new EventArgs());
        eventWithArg.fire(this, new EventArgs2<>("Event2", 2));

        eventRemoved.fire(this, new EventArgs3<>(this, 3, 3));
    }
}
