package com.noob.coder.PasswordGenerator.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String getHomeView(ModelMap model) {
		model.put("name","Wilson Shrestha");
		return "index";
	}
}
