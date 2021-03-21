package cn.hz.events;

public class EventArgs2<T1, T2>
{
	public EventArgs2(T1 data1, T2 data2)
	{
		setData1(data1);
		setData2(data2);
	}
	private T1 _data1;
	public final T1 getData1()
	{
		return _data1;
	}
	public final void setData1(T1 value)
	{
		_data1 = value;
	}
	private T2 _data2;
	public final T2 getData2()
	{
		return _data2;
	}
	public final void setData2(T2 value)
	{
		_data2 = value;
	}
}

