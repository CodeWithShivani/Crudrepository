package com.first.crudproject.pagecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/list")
	public String list()
	{
		return "list";
	}
	
	@GetMapping("/newlist")
	public String newlist()
	{
		return "newlist";
	}
	
	@GetMapping("/test")
	public String test()
	{
		return "test";
	}

}
