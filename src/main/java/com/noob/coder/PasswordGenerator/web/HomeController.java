package com.noob.coder.PasswordGenerator.web;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.noob.coder.PasswordGenerator.service.PasswordGeneratorService;

@Controller
public class HomeController {

	@Autowired
	private PasswordGeneratorService passwordService;

	@GetMapping("/")
	public String getHomeView(ModelMap model) throws NoSuchAlgorithmException {
		String password = passwordService.firstAlgorithm();
		model.put("password", password);
		return "index";
	}
}
