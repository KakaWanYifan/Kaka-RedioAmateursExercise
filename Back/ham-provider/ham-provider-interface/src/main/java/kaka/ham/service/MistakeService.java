package kaka.ham.service;

import java.util.List;

public interface MistakeService
{
	public List<String> getMistakeArr(String loginid, String category);

	public Integer setNewMistake(String loginid, String category, String topicid);

	public Integer setMistakeInvalid(String loginid, String category, String topicid);
}
