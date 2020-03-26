package kaka.ham.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaka.ham.mapper.MistakeMapper;
import kaka.ham.mapper.PracticeMapper;
import kaka.ham.mapper.SequenceMapper;
import kaka.ham.pojo.Chart;
import kaka.ham.pojo.Sequence;
import kaka.ham.pojo.Table;
import kaka.ham.pojo.TableRow;
import kaka.ham.pojo.ChartData;
import kaka.ham.pojo.Mistake;
import kaka.ham.pojo.Practice;
import kaka.ham.service.MoreService;

@Service
public class MoreServiceImpl implements MoreService
{
	@Autowired
	private SequenceMapper sequenceMapper;

	@Autowired
	private PracticeMapper practiceMapper;

	@Autowired
	private MistakeMapper mistakeMapper;

	@Override
	// 要返回三个图表类别
	public Map<String, Chart> getSequenceChart(String loginid)
	{
		Map<String, Chart> rnt = new HashMap<>();

		Chart chart_a = new Chart();
		Chart chart_b = new Chart();
		Chart chart_c = new Chart();

		List<ChartData> chartDataList_a = new ArrayList<>();
		List<ChartData> chartDataList_b = new ArrayList<>();
		List<ChartData> chartDataList_c = new ArrayList<>();

		Map<String, ChartData> chartDataMap_a = new HashMap<>();
		Map<String, ChartData> chartDataMap_b = new HashMap<>();
		Map<String, ChartData> chartDataMap_c = new HashMap<>();

		List<String> dayList = new ArrayList<>();
		DateTime now = DateTime.now();
		for (int i = 4; i >= 0; i--)
		{
			String string = now.plusDays(0 - i).toString("MM-dd");
			dayList.add(string);

			chartDataMap_a.put(string, new ChartData(string, "刷题数", 0));
			chartDataMap_b.put(string, new ChartData(string, "刷题数", 0));
			chartDataMap_c.put(string, new ChartData(string, "刷题数", 0));
		}
		chart_a.setDay(dayList);
		chart_b.setDay(dayList);
		chart_c.setDay(dayList);

		List<Sequence> sequencesList = sequenceMapper.getSequenceListFive(loginid);
		for (Sequence sequence : sequencesList)
		{
			DateTime dateTime = new DateTime(sequence.getCreated().getTime());
			if (dayList.contains(dateTime.toString("MM-dd")))
			{
				switch (sequence.getCategory())
				{
				case "a":
				{
					Integer vInteger = chartDataMap_a.get(dateTime.toString("MM-dd")).getValue();
					chartDataMap_a.get(dateTime.toString("MM-dd")).setValue(vInteger + 1);
				}
					break;
				case "b":
				{
					Integer vInteger = chartDataMap_b.get(dateTime.toString("MM-dd")).getValue();
					chartDataMap_b.get(dateTime.toString("MM-dd")).setValue(vInteger + 1);
				}
					break;
				case "c":
				{
					Integer vInteger = chartDataMap_c.get(dateTime.toString("MM-dd")).getValue();
					chartDataMap_c.get(dateTime.toString("MM-dd")).setValue(vInteger + 1);
				}
					break;
				}
			}
		}
		for (String key : dayList)
		{
			chartDataList_a.add(chartDataMap_a.get(key));
			chartDataList_b.add(chartDataMap_b.get(key));
			chartDataList_c.add(chartDataMap_c.get(key));
		}
		chart_a.setData(chartDataList_a);
		chart_b.setData(chartDataList_b);
		chart_c.setData(chartDataList_c);

		rnt.put("a", chart_a);
		rnt.put("b", chart_b);
		rnt.put("c", chart_c);
		return rnt;
	}

	@Override
	public Map<String, Chart> getPracticeChart(String loginid)
	{
		Map<String, Chart> rnt = new HashMap<>();
		rnt.put("a", PracticeChart_Category(loginid, "a"));
		rnt.put("b", PracticeChart_Category(loginid, "b"));
		rnt.put("c", PracticeChart_Category(loginid, "c"));
		return rnt;
	}

	private Chart PracticeChart_Category(String loginid, String category)
	{
		Chart rnt = new Chart();
		List<ChartData> chartDataList = new ArrayList<>();
		List<String> dayList = new ArrayList<>();
		List<Practice> practiceList = practiceMapper.getPracticeListFive(loginid, category);
		for (Practice practice : practiceList)
		{
			DateTime dateTime = new DateTime(practice.getCreated().getTime());
			String day = dateTime.toString("MM-dd") + "\n" + dateTime.toString("HH:mm");
			String type = "分数";
			Integer value = practice.getScore();
			ChartData chartData = new ChartData(day, type, value);
			chartDataList.add(0, chartData);
			//chartDataList.add(chartData);
			//dayList.add(day);
			dayList.add(0,day);
		}
		rnt.setData(chartDataList);
		rnt.setDay(dayList);
		return rnt;
	}

	@Override
	public Map<String, Table> getMistakeTable(String loginid)
	{
		Map<String, Table> rnt = new HashMap<>();
		Table table_a = new Table();
		Table table_b = new Table();
		Table table_c = new Table();
		Map<String, Object> theme = new HashMap<>();
		theme.put("date", "日期");
		theme.put("new", "新增错题");
		theme.put("resolve", "已移除错题");
		table_a.setTheme(theme);
		table_b.setTheme(theme);
		table_c.setTheme(theme);

		Map<String, TableRow> tableRowMap_a = new HashMap<>();
		Map<String, TableRow> tableRowMap_b = new HashMap<>();
		Map<String, TableRow> tableRowMap_c = new HashMap<>();
		
		List<TableRow> tableRowList_a = new ArrayList<>();
		List<TableRow> tableRowList_b = new ArrayList<>();
		List<TableRow> tableRowList_c = new ArrayList<>();

		
		DateTime now = DateTime.now();
		
		
		for (int i = 0; i <= 4; i++)
		{
			String string = now.plusDays(0 - i).toString("MM-dd");

			tableRowMap_a.put(string, new TableRow(string, 0, 0));
			tableRowMap_b.put(string, new TableRow(string, 0, 0));
			tableRowMap_c.put(string, new TableRow(string, 0, 0));
		}

		List<Mistake> mistakeList = mistakeMapper.getMisTakeListFive(loginid);
		for (Mistake mistake : mistakeList)
		{
			if (null != mistake.getInserted())
			{
				DateTime dateTime = new DateTime(mistake.getInserted().getTime());
				switch (mistake.getCategory())
				{
					case "a":
					{
						Integer vInteger = tableRowMap_a.get(dateTime.toString("MM-dd")).getNewTopic();
						tableRowMap_a.get(dateTime.toString("MM-dd")).setNewTopic(vInteger + 1);
					}
					break;
					case "b":
					{
						Integer vInteger = tableRowMap_b.get(dateTime.toString("MM-dd")).getNewTopic();
						tableRowMap_b.get(dateTime.toString("MM-dd")).setNewTopic(vInteger + 1);
					}
					break;
					case "c":
					{
						Integer vInteger = tableRowMap_c.get(dateTime.toString("MM-dd")).getNewTopic();
						tableRowMap_c.get(dateTime.toString("MM-dd")).setNewTopic(vInteger + 1);
					}
					break;
				}
			}
			if (null != mistake.getUpdated())
			{
				DateTime dateTime = new DateTime(mistake.getUpdated().getTime());
				switch (mistake.getCategory())
				{
				case "a":
				{
					Integer vInteger = tableRowMap_a.get(dateTime.toString("MM-dd")).getResolveTopic();
					tableRowMap_a.get(dateTime.toString("MM-dd")).setResolveTopic(vInteger + 1);
				}
				break;
				case "b":
				{
					Integer vInteger = tableRowMap_b.get(dateTime.toString("MM-dd")).getResolveTopic();
					tableRowMap_b.get(dateTime.toString("MM-dd")).setResolveTopic(vInteger + 1);
				}
				break;
				case "c":
				{
					Integer vInteger = tableRowMap_c.get(dateTime.toString("MM-dd")).getResolveTopic();
					tableRowMap_c.get(dateTime.toString("MM-dd")).setResolveTopic(vInteger + 1);
				}
				break;
				}
			}
		}
		for (int i = 0; i <= 4; i++)
		{
			String key = now.plusDays(0 - i).toString("MM-dd");
			
			tableRowList_a.add(tableRowMap_a.get(key));
			tableRowList_b.add(tableRowMap_b.get(key));
			tableRowList_c.add(tableRowMap_c.get(key));
		}
		table_a.setTableRow(tableRowList_a);
		table_b.setTableRow(tableRowList_b);
		table_c.setTableRow(tableRowList_c);
		
		rnt.put("a", table_a);
		rnt.put("b", table_b);
		rnt.put("c", table_c);
		
		return rnt;
	}

}
