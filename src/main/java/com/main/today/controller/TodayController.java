package com.main.today.controller;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.main.today.model.biz.Biz;
import com.main.today.model.dto.TodayMember;

@Controller
@RequestMapping("/main")
public class TodayController {
	
	@Autowired
	private Biz biz;
	
	
	@RequestMapping("/mainlist")
	public String mainlist() {
		return "main";
	}
	
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "registerForm";
	}
	
	@RequestMapping("/regist")
	public String regist(TodayMember dto) {
		int res = biz.insertRegist(dto);
		
		return "success";
	}
	
	@RequestMapping(value="/checkId", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> checkId(@RequestBody TodayMember dto){
		
		boolean check = false;
		Map<String, Boolean> map = new HashMap<>();
		
		TodayMember dto1 = biz.checkId(dto);
		
		if(dto1 == null) {
			check = true;
			map.put("check", check);
			return map;
		}else {
			map.put("check", check);
			return map;
		}
	}
	
	
	
	
}
