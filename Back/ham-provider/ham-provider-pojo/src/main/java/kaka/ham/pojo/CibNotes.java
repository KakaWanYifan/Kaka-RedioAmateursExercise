package kaka.ham.pojo;

import java.io.Serializable;

public class CibNotes implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5580865288149234513L;
	
	private Long id;
	private String code;
	private String notes;
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
	public String getNotes()
	{
		return notes;
	}
	public void setNotes(String notes)
	{
		this.notes = notes;
	}
	
	
}
