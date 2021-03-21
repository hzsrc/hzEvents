package cn.hz.events;


public class EventArgs4<T1, T2, T3, T4> {

    public EventArgs4() {

    }

    public EventArgs4(T1 data1, T2 data2, T3 data3, T4 data4) {
        _data1 = data1;
        _data2 = data2;
        _data3 = data3;
        _data4 = data4;
    }

    private T1 _data1;
    private T2 _data2;
    private T3 _data3;
    private T4 _data4;

    public T1 getData1() {
        return _data1;
    }

    public void setData1(T1 v) {
        _data1 = v;
    }

    public T2 getData2() {
        return _data2;
    }

    public void setData2(T2 v) {
        _data2 = v;
    }

    public T3 getData3() {
        return _data3;
    }

    public void setData3(T3 v) {
        _data3 = v;
    }

    public T4 getData4() {
        return _data4;
    }

    public void setData4(T4 v) {
        _data4 = v;
    }

}
