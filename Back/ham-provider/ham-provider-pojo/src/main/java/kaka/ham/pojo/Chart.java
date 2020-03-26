package kaka.ham.pojo;

import java.io.Serializable;
import java.util.List;


public class Chart implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3182864281011984206L;
	
	private List<String> day;
	private List<ChartData> data;
	public List<String> getDay()
	{
		return day;
	}
	public void setDay(List<String> day)
	{
		this.day = day;
	}
	public List<ChartData> getData()
	{
		return data;
	}
	public void setData(List<ChartData> data)
	{
		this.data = data;
	}
	@Override
	public String toString()
	{
		return "Chart [day=" + day + ", data=" + data + "]";
	}
	
	
}
