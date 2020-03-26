package kaka.ham.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.service.LoginService;
import kaka.ham.service.SequenceService;

@Controller
public class SequenceController
{
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SequenceService sequenceService;
	
	@RequestMapping("/setSequence/{code_loginid}/{category}/{value}/{lastSequence}/{thisSequence}")
	@ResponseBody
	public Integer setSequence(@PathVariable String code_loginid,@PathVariable String category,@PathVariable String value,@PathVariable Integer lastSequence,@PathVariable Integer thisSequence)
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
		rnt = sequenceService.setSequence(loginid, category, lastSequence, thisSequence);
		return rnt;
	}
}
