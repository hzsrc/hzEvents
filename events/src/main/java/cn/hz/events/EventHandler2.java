package cn.hz.events;

@FunctionalInterface
public interface EventHandler2<T1, T2> extends EventHandler_Base<EventArgs2<T1, T2>> {
//    @Override
//    void invoke(Object sender, DataEventArgs2<T1, T2> args);
}
