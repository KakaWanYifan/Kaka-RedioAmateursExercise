package kaka.ham.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kaka.ham.mapper.SequenceMapper;
import kaka.ham.pojo.Sequence;
import kaka.ham.service.SequenceService;
@Service
public class SequenceServiceImpl implements SequenceService
{
	@Autowired
	private SequenceMapper sequenceMapper;
	
	@Override
	public Integer getSequence(String loginid,String category)
	{
		Integer rnt = 0;
		Sequence sequence = sequenceMapper.getSequence(loginid,category);
		if (null == sequence)
		{
			rnt = 0;
		}
		else
		{
			rnt = sequence.getStep();
		}
		return rnt;
	}

	@Override
	public Integer setSequence(String loginid, String category, Integer lastSequence, Integer thisSequence)
	{
		Integer rnt = 0;
		Integer temp = 0;
		temp = sequenceMapper.setSequenceInvalid(loginid, lastSequence, category);
		rnt = rnt + (null == temp ? 0 : temp);
//		rnt = rnt + sequenceMapper.setSequenceInvalid(loginid, lastSequence, category);
		//rnt = rnt + sequenceMapper.setSequenceInvalid(loginid, category);
		//rnt = rnt +  sequenceMapper.setNewSequence(loginid, thisSequence, category);
		temp = sequenceMapper.setNewSequence(loginid, thisSequence, category);
		rnt = rnt + (null == temp ? 0 : temp);
		return rnt;
	}

}
