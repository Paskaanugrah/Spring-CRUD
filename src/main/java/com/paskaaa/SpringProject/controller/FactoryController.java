package com.paskaaa.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/new")
	public String showNewFactoryPage(Model model) {
		Factory factory = new Factory();
		
		model.addAttribute("factory", factory);
		
		return "factory/create";
	}
	
	@PostMapping(value = "/save")
	public String saveFactory(@ModelAttribute("factory") Factory factory) {
		service.save(factory);
		System.out.println("------------------------------------------------------------------");
		return "redirect:/factory";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPage(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView("factory/edit");
		
		Factory factory = service.getById(id);
		mav.addObject("factory", factory);
		
		return mav;
	}
	
	@RequestMapping("delete/{id}")
	public String deleteFactory(@PathVariable("id") Integer id) {
		service.delete(id);
		
		return "redirect:/factory";
	}
}
