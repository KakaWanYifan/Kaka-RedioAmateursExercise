package kaka.ham.pojo;

import java.io.Serializable;

public class ChartData implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5763017157101608067L;
	
	
	
	public ChartData(String day, String type, Integer value)
	{
		super();
		this.day = day;
		this.type = type;
		this.value = value;
	}
	
	private String day;
	private String type;
	private Integer value;
	public String getDay()
	{
		return day;
	}
	public void setDay(String day)
	{
		this.day = day;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public Integer getValue()
	{
		return value;
	}
	public void setValue(Integer value)
	{
		this.value = value;
	}
	@Override
	public String toString()
	{
		return "chartData [day=" + day + ", type=" + type + ", value=" + value + "]";
	}
}
