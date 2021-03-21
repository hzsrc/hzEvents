package cn.hz.events;

@FunctionalInterface
public interface EventHandler extends EventHandler_Base<EventArgs> {
    @Override
    void invoke(Object sender, EventArgs args);
}
