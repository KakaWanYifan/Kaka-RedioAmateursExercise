package kaka.ham.service;


public interface SequenceService
{
	public Integer getSequence(String loginid,String category);
	
	public Integer setSequence(String loginid,String category,Integer lastSequence,Integer thisSequence);
}
