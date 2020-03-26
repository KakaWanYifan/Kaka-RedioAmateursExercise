package kaka.ham.pojo;

import java.io.Serializable;
import java.util.Date;

public class Mistake implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8623061917469585399L;
	
	private Long id;
	private String loginid;
	private String topicid;
	private String category;
	private Date inserted;
	private Date updated;
	private Integer state;
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getLoginid()
	{
		return loginid;
	}
	public void setLoginid(String loginid)
	{
		this.loginid = loginid;
	}
	
	
	
	public String getTopicid()
	{
		return topicid;
	}
	public void setTopicid(String topicid)
	{
		this.topicid = topicid;
	}
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public Date getInserted()
	{
		return inserted;
	}
	public void setInserted(Date inserted)
	{
		this.inserted = inserted;
	}
	public Date getUpdated()
	{
		return updated;
	}
	public void setUpdated(Date updated)
	{
		this.updated = updated;
	}
	public Integer getState()
	{
		return state;
	}
	public void setState(Integer state)
	{
		this.state = state;
	}
	@Override
	public String toString()
	{
		return "Mistake [id=" + id + ", loginid=" + loginid + ", topicid=" + topicid + ", category=" + category
				+ ", inserted=" + inserted + ", updated=" + updated + ", state=" + state + "]";
	}
	
	
	
	
	
}
