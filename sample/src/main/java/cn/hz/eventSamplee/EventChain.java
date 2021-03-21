package cn.hz.eventSamplee;

import cn.hz.events.*;

public class EventChain {
    Event2<String, Integer> chainEvent = new Event2<>();

    //chain event by another event
    public EventChain(Subject subject) {
        subject.eventWithArg.addChain(chainEvent);
    }
}
