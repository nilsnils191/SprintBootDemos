package com.mvc.boot.springbootmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.boot.springbootmvc.models.LMS_TBL;
import com.mvc.boot.springbootmvc.repository.service.LmsService;

@RestController
public class MainController {

	@Autowired
	private LmsService lmsService;
	
	@GetMapping("/helloJsp")
	public String init() {
		return "index";
	}
	
	@GetMapping("/getAllBooks")
	public List<LMS_TBL> getAllBooks() {
		return lmsService.getAllBooks();
	}
}
