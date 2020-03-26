package kaka.ham.mapper;

import java.util.List;

import kaka.ham.pojo.Practice;

public interface PracticeMapper
{

	Integer setPractive(String loginid, String category, Integer score);
	
	List<Practice> getPracticeListFive(String loginid,String category);
}
