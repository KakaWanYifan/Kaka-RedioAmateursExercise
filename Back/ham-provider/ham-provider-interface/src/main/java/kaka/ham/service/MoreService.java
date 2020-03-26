package kaka.ham.service;

import java.util.Map;

import kaka.ham.pojo.Chart;
import kaka.ham.pojo.Table;

public interface MoreService
{
	public Map<String, Chart> getSequenceChart(String loginid);

	public Map<String, Chart> getPracticeChart(String loginid);

	public Map<String, Table> getMistakeTable(String loginid);
}
