package kaka.ham.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class IndexM implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7182816311638135062L;
	
	private String category;
	private Integer[] sequenceArr;
	private Integer[] practiceArr;
	private Integer[] mistakeArr;
	
	
	public String getCategory()
	{
		return category;
	}
	public void setCategory(String category)
	{
		this.category = category;
	}
	public Integer[] getSequenceArr()
	{
		return sequenceArr;
	}
	public void setSequenceArr(Integer[] sequenceArr)
	{
		this.sequenceArr = sequenceArr;
	}
	public Integer[] getPracticeArr()
	{
		return practiceArr;
	}
	public void setPracticeArr(Integer[] practiceArr)
	{
		this.practiceArr = practiceArr;
	}
	public Integer[] getMistakeArr()
	{
		return mistakeArr;
	}
	public void setMistakeArr(Integer[] mistakeArr)
	{
		this.mistakeArr = mistakeArr;
	}
	@Override
	public String toString()
	{
		return "indexM [category=" + category + ", sequenceArr=" + Arrays.toString(sequenceArr) + ", practiceArr="
				+ Arrays.toString(practiceArr) + ", mistakeArr=" + Arrays.toString(mistakeArr) + "]";
	}
	
	
}
