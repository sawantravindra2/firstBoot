package com.firstboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("welcome")
	public String welcome() {
		System.out.println("inside welcome page loading");
		return "welcome";

	}

}
