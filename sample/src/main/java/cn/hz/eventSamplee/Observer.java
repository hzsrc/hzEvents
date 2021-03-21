package cn.hz.eventSamplee;

import cn.hz.events.*;

public class Observer {
    public void bindEvents(Subject subject, EventChain chain) {
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
        //remove event binding. event3 not shown
        subject.eventRemoved.removeListener(handler3); //must be the same as addListener
    }

    private void onEvent3(Object o, EventArgs3<Subject, Integer, Integer> e) {
        System.out.println("event3 fired, args: " + e.getData1() + "," + e.getData2() + "," + e.getData3());
    }
}
