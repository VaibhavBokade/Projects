package com.sport.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.demo.service.SportService;

@RestController
@RequestMapping("/sports")
public class SportController {
	@Autowired
	private SportService sportService;

	

}
