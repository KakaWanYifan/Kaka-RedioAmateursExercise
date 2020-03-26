package kaka.ham.mapper;

import java.util.List;

import kaka.ham.pojo.Sequence;

public interface SequenceMapper
{
	Sequence getSequence(String loginid,String category);
	
	Integer setSequenceInvalid(String loginid,Integer lastSequence,String category);
	
	//Integer setSequenceInvalid(String loginid,String category);
	
	Integer setNewSequence(String loginid,Integer thisSequence,String category);
	
	List<Sequence> getSequenceListFive(String loginid);
}
