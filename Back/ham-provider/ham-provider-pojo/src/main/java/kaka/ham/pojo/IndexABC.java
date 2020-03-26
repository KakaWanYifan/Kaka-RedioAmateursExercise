package kaka.ham.pojo;

import java.io.Serializable;
import java.util.List;

public class IndexABC implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7027411196646116417L;
	
	private String category;
	private Integer sequence;
	private List<String> mistake;
	
	
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public Integer getSequence()
	{
		return sequence;
	}
	public void setSequence(Integer sequence)
	{
		this.sequence = sequence;
	}
	public List<String> getMistake()
	{
		return mistake;
	}
	public void setMistake(List<String> mistake)
	{
		this.mistake = mistake;
	}
	@Override
	public String toString()
	{
		return "IndexABC [category=" + category + ", sequence=" + sequence + ", mistake=" + mistake + "]";
	}
}
