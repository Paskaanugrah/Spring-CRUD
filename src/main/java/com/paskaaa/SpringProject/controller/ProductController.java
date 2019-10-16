package com.paskaaa.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.paskaaa.SpringProject.entity.Product;
import com.paskaaa.SpringProject.entity.Shop;
import com.paskaaa.SpringProject.services.ProductService;
import com.paskaaa.SpringProject.services.ShopService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping()
	public String viewProductPage(Model model) {
		List<Product> products = service.listAll();
		List<Shop> shops = shopService.listAll();

		model.addAttribute("products" , products);
		model.addAttribute("shops" , shops);
		
		return "product/product";
	}
	
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		List<Shop> shops = shopService.listAll();
		model.addAttribute("product", product);
		model.addAttribute("shops", shops);
		
		return "product/create";
	}	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		try {
			service.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/product";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPage(@PathVariable(name = "id") Integer id) {
		ModelAndView mav = new ModelAndView("product/edit");
		
		Product product = service.getById(id);
		List<Shop> shops = shopService.listAll();
		
		mav.addObject("product", product);
		mav.addObject("shops", shops);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Integer id) {
		service.delete(id);
		
		return "redirect:/product";
		
	}
}