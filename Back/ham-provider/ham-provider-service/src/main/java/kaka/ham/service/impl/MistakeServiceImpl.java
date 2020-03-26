package kaka.ham.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaka.ham.mapper.MistakeMapper;
import kaka.ham.pojo.Mistake;
import kaka.ham.service.MistakeService;

@Service
public class MistakeServiceImpl implements MistakeService
{
	@Autowired
	private MistakeMapper mistakeMapper;
	
	@Override
	public Integer setNewMistake(String loginid, String category,String topicid)
	{
		Integer rnt = 0;
		Integer condition = mistakeMapper.getCountByTopicid(loginid, category, topicid);
		if (condition == 0)
		{
			rnt = mistakeMapper.setNewMistake(loginid, category, topicid);
		}
		return rnt;
	}
	
	@Override
	public List<String> getMistakeArr(String loginid, String category)
	{
		List<String> rnt = new ArrayList<>();
		List<Mistake> mistakeList = mistakeMapper.getMistakeList(loginid, category);
		for (Mistake mistake : mistakeList)
		{
			rnt.add(mistake.getTopicid());
		}
		return rnt;
	}

	@Override
	public Integer setMistakeInvalid(String loginid, String category, String topicid)
	{
		Integer rnt = mistakeMapper.setMistakeInvalid(loginid, category, topicid);
		return rnt;
	}

}
