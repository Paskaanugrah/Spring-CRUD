package com.paskaaa.SpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.paskaaa.SpringProject.entity.Product;
import com.paskaaa.SpringProject.entity.Shop;
import com.paskaaa.SpringProject.services.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@RequestMapping()
	public String viewShopPage(Model model) {
		List<Shop> shops = service.listAll();
		model.addAttribute("shops", shops);
//		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++" + shops);
		return "shop/shop";
	}
	
	@RequestMapping("/new")
	public String showNewStringShopForm(Model model) {
		Shop shop = new Shop();
		model.addAttribute(shop);
		
		return "shop/create";
	}
	
	@PostMapping(value = "/save")
	public String saveShop(@ModelAttribute("shop") Shop shop) {
		service.save(shop);
		
		return "redirect:/shop";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPage(@PathVariable(name = "id") Integer id ) {
		ModelAndView mav = new ModelAndView("shop/edit");
		
		Shop shop = service.getById(id);
		mav.addObject("shop", shop);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteShop(@PathVariable(name = "id") Integer id) {
		service.delete(id);
		
		return "redirect:/shop";
	}
}
