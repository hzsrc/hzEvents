package cn.hz.eventSamplee;

import cn.hz.events.*;

public class Observer {
    public void bindEvents(Subject subject, EventChain chain) {
        // bind event listeners
        subject.event1.addListener((o, e) -> {
            System.out.println("event1 fired.");
        });

        subject.eventWithArg.addListener((o, e) -> {
            System.out.println("eventWithArg fired, args: " + e.getData1() + "," + e.getData2());
        });

        chain.chainEvent.addListener((o, e) -> {
            System.out.println("chainEvent fired, args: " + e.getData1() + "," + e.getData2());
        });

        EventHandler3<Subject, Integer, Integer> handler3 = this::onEvent3;
        subject.eventRemoved.addListener(handler3);
        //remove event binding. message of event3 will not be shown
        subject.eventRemoved.removeListener(handler3); //Target must be exactly the same as addListener() !
    }

    private void onEvent3(Object o, EventArgs3<Subject, Integer, Integer> e) {
        System.out.println("event3 fired, args: " + e.getData1() + "," + e.getData2() + "," + e.getData3());
    }
}
