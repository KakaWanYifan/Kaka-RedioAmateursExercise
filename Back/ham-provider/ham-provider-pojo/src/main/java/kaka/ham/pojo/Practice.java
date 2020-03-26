package kaka.ham.pojo;

import java.io.Serializable;
import java.util.Date;

public class Practice implements Serializable
{
//	CREATE TABLE `practice` (
//			  `id` bigint(128) NOT NULL,
//			  `loginid` varchar(45) DEFAULT NULL,
//			  `score` int(11) DEFAULT NULL,
//			  `practicecol` varchar(45) DEFAULT NULL,
//			  PRIMARY KEY (`id`)
//			) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6469909327000404445L;
	
	private Long id;
	private String loginid;
	private String category;
	private Integer score;
	private Date created;
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
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public Integer getScore()
	{
		return score;
	}
	public void setScore(Integer score)
	{
		this.score = score;
	}
	
	public Date getCreated()
	{
		return created;
	}
	public void setCreated(Date created)
	{
		this.created = created;
	}
	@Override
	public String toString()
	{
		return "Practice [id=" + id + ", loginid=" + loginid + ", category=" + category + ", score=" + score
				+ ", created=" + created + "]";
	}
	
	
}
