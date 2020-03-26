package kaka.ham.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Table implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5193159315760266320L;
	
	private Map<String, Object> theme;
	private List<TableRow> tableRow;
	public Map<String, Object> getTheme()
	{
		return theme;
	}
	public void setTheme(Map<String, Object> theme)
	{
		this.theme = theme;
	}
	
	public List<TableRow> getTableRow()
	{
		return tableRow;
	}
	public void setTableRow(List<TableRow> tableRow)
	{
		this.tableRow = tableRow;
	}
	@Override
	public String toString()
	{
		return "Table [theme=" + theme + ", tableRow=" + tableRow + "]";
	}
	
	
	
	
	
}
