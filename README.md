# hzEvents
A cSharp-like event model for java, decoupe code gracefully.  
Java中完美实现C#的EventHandler事件模式，代码优雅解耦合。


# Usage
### Subject
Class which supply events and fire events.  
包含事件并触发事件的类。
````java
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
````

### Observer
Class which subscribe events.   
事件订阅者（或观察者）.
````java
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
````

详见源码(Source code)：https://github.com/hzsrc/hzEvents
