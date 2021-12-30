package com.example.tp5.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@GetMapping ("/greeting")
	public String greeting(@RequestParam (value="nameGET",
		required =false , defaultValue =" World ") String
		nameGET, Model model) {
			model.addAttribute ("nomTemplate",nameGET ) ;
			return "greeting";
	}
	
}
