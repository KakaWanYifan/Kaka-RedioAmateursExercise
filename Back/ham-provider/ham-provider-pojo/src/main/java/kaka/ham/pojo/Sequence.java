package kaka.ham.pojo;

import java.io.Serializable;
import java.util.Date;

public class Sequence implements Serializable
{
//	CREATE TABLE `sequence` (
//			  `id` bigint(128) NOT NULL,
//			  `loginid` varchar(45) DEFAULT NULL,
//			  `step` int(11) DEFAULT NULL,
//			  `created` datetime DEFAULT NULL,
//			  `state` int(11) DEFAULT NULL,
//			  PRIMARY KEY (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	/**
	 * 
	 */
	private static final long serialVersionUID = 926755327979325522L;
	
	private Long id;
	private String loginid;
	private Integer step;
	private String category;
	private Date created;
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
	public Integer getStep()
	{
		return step;
	}
	public void setStep(Integer step)
	{
		this.step = step;
	}
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
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
		return "sequence [id=" + id + ", loginid=" + loginid + ", step=" + step + ", created=" + created + ", state="
				+ state + "]";
	}
	
	
}
