package com.paskaaa.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paskaaa.SpringProject.entity.Product;
import com.paskaaa.SpringProject.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/product")
	public String viewProductPage(Model model) {
		List<Product> products = service.listAll();
		model.addAttribute("products" , products);
		return "product";
	}
}
