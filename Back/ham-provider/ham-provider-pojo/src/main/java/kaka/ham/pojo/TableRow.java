package kaka.ham.pojo;

import java.io.Serializable;

public class TableRow implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4453764549386984427L;
	
	private String date;
	private Integer newTopic;
	private Integer resolveTopic;
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public Integer getNewTopic()
	{
		return newTopic;
	}
	public void setNewTopic(Integer newTopic)
	{
		this.newTopic = newTopic;
	}
	public Integer getResolveTopic()
	{
		return resolveTopic;
	}
	public void setResolveTopic(Integer resolveTopic)
	{
		this.resolveTopic = resolveTopic;
	}
	@Override
	public String toString()
	{
		return "TableRow [date=" + date + ", newTopic=" + newTopic + ", resolveTopic=" + resolveTopic + "]";
	}
	public TableRow(String date, Integer newTopic, Integer resolveTopic)
	{
		super();
		this.date = date;
		this.newTopic = newTopic;
		this.resolveTopic = resolveTopic;
	}
	
	

}
