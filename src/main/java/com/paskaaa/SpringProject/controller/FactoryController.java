package com.paskaaa.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paskaaa.SpringProject.entity.Factory;
import com.paskaaa.SpringProject.services.FactoryService;

@Controller
@RequestMapping("/factory")
public class FactoryController {
	
	@Autowired
	private FactoryService service;
	
	@RequestMapping()
	public String showFactoryPage(Model model) {
		List<Factory> factorys = service.listAll();
		
		model.addAttribute("factorys", factorys);
		
		return "factory/factory";
	}
	
	
}
