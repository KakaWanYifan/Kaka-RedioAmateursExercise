package kaka.ham.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.yetus.audience.InterfaceAudience.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.service.LoginService;
import kaka.ham.service.MistakeService;

@Controller
public class MistakeController
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MistakeService mistakeService;
	
	//index是LK开头的
	@RequestMapping("/setMistakeInvalid/{code_loginid}/{category}/{value}/{topicid}")
	@ResponseBody
	public Integer setMistakeInvalid(@PathVariable String code_loginid,@PathVariable String category,@PathVariable String value,@PathVariable String topicid)
	{
		Integer rnt = 0;
		String loginid = "";
		if ("code".equals(code_loginid))
		{
			Map<String, Object> loginMap = new HashMap<>();
			loginMap = loginService.getOpenid(value);
			loginid = loginMap.get("openid").toString();
		}
		else
		{
			loginid = value;
		}
		rnt = mistakeService.setMistakeInvalid(loginid, category, topicid);
		return rnt;
	}
	
	@RequestMapping("/setNewMistakeList")
	@ResponseBody
	@Public Integer setNewMistakeList(@RequestParam("mistakeList")  List<String> mistakeList,
			@RequestParam("code_loginid") String code_loginid,
			@RequestParam("category") String category,
			@RequestParam("value") String value)
	{
		Integer rnt = 0;
		String loginid = "";
		if ("code".equals(code_loginid))
		{
			Map<String, Object> loginMap = new HashMap<>();
			loginMap = loginService.getOpenid(value);
			loginid = loginMap.get("openid").toString();
		}
		else
		{
			loginid = value;
		}
		for (String topicid : mistakeList)
		{
			rnt = mistakeService.setNewMistake(loginid, category, topicid);
		}
		return rnt;
	}
	
	//index是LK开头的
	@RequestMapping("/setNewMistake/{code_loginid}/{category}/{value}/{topicid}")
	@ResponseBody
	public Integer setNewMistake(@PathVariable String code_loginid,@PathVariable String category,@PathVariable String value,@PathVariable String topicid)
	{
		Integer rnt = 0;
		String loginid = "";
		if ("code".equals(code_loginid))
		{
			Map<String, Object> loginMap = new HashMap<>();
			loginMap = loginService.getOpenid(value);
			loginid = loginMap.get("openid").toString();
		}
		else
		{
			loginid = value;
		}
		rnt = mistakeService.setNewMistake(loginid, category, topicid);
		return rnt;
	}
}
