package com.noob.coder.PasswordGenerator.web;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.noob.coder.PasswordGenerator.entity.HomeEntity;
import com.noob.coder.PasswordGenerator.service.ICheckAlgorithmService;

@Controller
public class HomeController {

	@Autowired
	private ICheckAlgorithmService service;

	@GetMapping("/")
	public String getHomeView(ModelMap model, HomeEntity homeEntity) throws NoSuchAlgorithmException {
		String password = service.checkAlgorithm(homeEntity);
		model.put("password", password);
		model.put("homeEntity", homeEntity);
		return "index";
	}
}
