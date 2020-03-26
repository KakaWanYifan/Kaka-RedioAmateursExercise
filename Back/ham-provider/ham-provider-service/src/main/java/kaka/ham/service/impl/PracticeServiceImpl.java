package kaka.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaka.ham.mapper.PracticeMapper;
import kaka.ham.service.PracticeService;

@Service
public class PracticeServiceImpl implements PracticeService
{
	@Autowired
	private PracticeMapper practiceMapper;

	@Override
	public Integer setPractive(String loginid, String category, Integer score)
	{
		Integer rnt = practiceMapper.setPractive(loginid,category,score);
		return rnt;
	}

}
