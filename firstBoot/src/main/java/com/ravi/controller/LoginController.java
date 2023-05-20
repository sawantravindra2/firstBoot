package com.ravi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String welcome() {
		System.out.println("inside welcome page loading");
		return "welcome";

	}

}
