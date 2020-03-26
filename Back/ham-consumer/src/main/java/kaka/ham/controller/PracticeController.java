package kaka.ham.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.service.LoginService;
import kaka.ham.service.PracticeService;

@Controller
public class PracticeController
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PracticeService practiceService;
	
	@RequestMapping("/setPractice/{code_loginid}/{category}/{value}/{score}")
	@ResponseBody
	public Integer setPractice(@PathVariable String code_loginid,@PathVariable String category,@PathVariable String value,@PathVariable Integer score)
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
		rnt = practiceService.setPractive(loginid, category, score);
		return rnt;
	}
}
