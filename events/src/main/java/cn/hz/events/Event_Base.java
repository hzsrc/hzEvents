package cn.hz.events;

import java.util.ArrayList;
import java.util.List;

public class Event_Base<Handler extends EventHandler_Base<Arg>, Arg> {
    private List<Handler> listeners = new ArrayList<Handler>();
    private List<Event_Base<Handler, Arg>> chains = new ArrayList<>();

    public boolean isEmpty() {
        return listeners.size() + chains.size() == 0;
    }

    public List<Handler> getListeners() {
        return listeners;
    }

    public void addListener(Handler handler) {
        listeners.add(handler);
    }

    public boolean removeListener(Handler handler) {
        int i = listeners.indexOf(handler);
        if (i > -1) listeners.remove(i);
        return i > -1;
    }

    public void addChain(Event_Base<Handler, Arg> event2) {
        chains.add(event2);
    }

    public boolean removeChain(Event_Base<Handler, Arg> event2) {
        int i = chains.indexOf(event2);
        if (i > -1) chains.remove(i);
        return i > -1;
    }

    public void fire(Object sender, Arg e) {
        for (Handler h : listeners) {
            h.invoke(sender, e);
        }
        for (Event_Base<Handler, Arg> event2 : chains) {
            event2.fire(sender, e);
        }
    }
}
