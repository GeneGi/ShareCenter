package net.jimmyme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminController {

	@RequestMapping(value="/user")
	public String userInfo(){
		
		
		return "/admin/user";
	}
}
