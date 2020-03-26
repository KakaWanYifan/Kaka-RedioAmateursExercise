package kaka.ham.mapper;

import java.util.List;

import kaka.ham.pojo.Mistake;

public interface MistakeMapper
{
	List<Mistake> getMistakeList(String loginid,String category);
	
	Integer setNewMistake(String loginid,String category,String topicid);
	
	Integer getCountByTopicid(String loginid,String category,String topicid);

	Integer setMistakeInvalid(String loginid, String category, String topicid);
	
	List<Mistake> getMisTakeListFive(String loginid);
}
