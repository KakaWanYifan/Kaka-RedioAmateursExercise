package kaka.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaka.ham.mapper.CibNotesMapper;
import kaka.ham.service.CibNotesService;

@Service
public class CibNotesServiceImpl implements CibNotesService
{
	@Autowired
	private CibNotesMapper cibNotesMapper;
	
	
	@Override
	public Integer setCibNotes(String loginid, String notes)
	{
		Integer rnt = cibNotesMapper.setCibNotes(loginid, notes);
		return rnt;
	}

	@Override
	public String getCibNotes(String loginid)
	{
		String rnt = cibNotesMapper.getCibNotes(loginid);
		return rnt;
	}

}
