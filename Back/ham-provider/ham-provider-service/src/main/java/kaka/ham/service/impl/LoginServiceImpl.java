package kaka.ham.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import kaka.ham.parameter.para;
import kaka.ham.service.LoginService;
import kaka.ham.util.HttpClientHelper;

@Service
@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
public class LoginServiceImpl implements LoginService
{

	//开放接口 · 小程序
	//https://developers.weixin.qq.com/miniprogram/dev/api/api-login.html#wxloginobject
	//肯定是unchecked
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getOpenid(String code)
	{
		Map<String, Object> params = new HashMap<>();
		params.put("appid", para.appid);
		params.put("secret", para.secret);
		params.put("js_code", code);
		params.put("grant_type", para.grant_type);
		String jsonStr = HttpClientHelper.sendPost_HttpURL(para.loginUrl, params, "UTF-8");
		Gson gson = new Gson();
		Map<String, Object> map = new HashMap<>();
		map = gson.fromJson(jsonStr,map.getClass());
		return map;
	}
}
