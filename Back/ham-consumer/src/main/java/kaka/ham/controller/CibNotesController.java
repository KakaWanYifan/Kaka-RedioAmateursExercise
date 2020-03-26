package kaka.ham.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kaka.ham.service.CibNotesService;
import kaka.ham.service.LoginService;

@Controller
public class CibNotesController
{
	@Autowired
	private CibNotesService cibNotesService;
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("setCibNotes/{code_loginid}/{value}/{notes}")
	@ResponseBody
	public Integer setCibNotes (@PathVariable String code_loginid,@PathVariable String value,@PathVariable String notes)
	{
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
		Integer rnt = cibNotesService.setCibNotes(loginid, notes);
		return rnt;
	}
	
	@RequestMapping("getCibNotes/{code_loginid}/{value}")
	@ResponseBody
	public String getCibNotes(@PathVariable String code_loginid,@PathVariable String value)
	{
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
		String rnt = cibNotesService.getCibNotes(loginid);
		return rnt;
	}
}
