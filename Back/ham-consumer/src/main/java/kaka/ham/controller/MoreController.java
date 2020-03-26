package kaka.ham.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.service.LoginService;
import kaka.ham.service.MoreService;

@Controller
public class MoreController
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MoreService moreService;
	
	@RequestMapping("/getChart/{code_loginid}/{value}")
	@ResponseBody
	public Map<String, Object> getChart(@PathVariable String code_loginid,@PathVariable String value)
	{
		Map<String, Object> rnt = new HashMap<>();
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
		rnt.put("sequenceChart", moreService.getSequenceChart(loginid));
		rnt.put("practiceChart", moreService.getPracticeChart(loginid));
		rnt.put("mistakeTable", moreService.getMistakeTable(loginid));
		return rnt;
	}
}
