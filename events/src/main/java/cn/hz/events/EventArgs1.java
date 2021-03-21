package cn.hz.events;

public class EventArgs1<T>
{
	public EventArgs1(T data)
	{
		setData(data);
	}
	private T data;
	public final T getData()
	{
		return data;
	}
	public final void setData(T value)
	{
		data = value;
	}
}
