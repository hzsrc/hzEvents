package cn.hz.events;

@FunctionalInterface
public interface EventHandler_Base<T> {
    void invoke(Object sender, T e);
}

