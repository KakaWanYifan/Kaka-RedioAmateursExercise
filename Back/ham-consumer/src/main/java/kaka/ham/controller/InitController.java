package kaka.ham.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.pojo.IndexABC;
import kaka.ham.service.LoginService;
import kaka.ham.service.MistakeService;
import kaka.ham.service.SequenceService;

@Controller
public class InitController
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private MistakeService mistakeService;
	
	@RequestMapping("/login/{code}")
	@ResponseBody
	public Map<String, Object> login(@PathVariable String code)
	{
		Map<String, Object> rnt = new HashMap<>();
		rnt = loginService.getOpenid(code);
		return rnt;
	} 
	
	@RequestMapping("/initABC/{code_loginid}/{category}/{value}")
	@ResponseBody
	public IndexABC initABC(@PathVariable String code_loginid,@PathVariable String category,@PathVariable String value)
	{
		IndexABC rnt = new IndexABC();
		rnt.setCategory(category);
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
		Integer sequence = sequenceService.getSequence(loginid, category);
		rnt.setSequence(sequence);
		List<String> mistakeList = mistakeService.getMistakeArr(loginid, category);
		rnt.setMistake(mistakeList);
		return rnt;
	}
}
