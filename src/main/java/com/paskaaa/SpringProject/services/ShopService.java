package com.paskaaa.SpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paskaaa.SpringProject.entity.Shop;
import com.paskaaa.SpringProject.repository.ShopRepository;

@Service
public class ShopService {
	
	@Autowired
	private ShopRepository repo;
	
	public List<Shop> listAll() {
		return repo.findAll();
	}
	
	public Shop getById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void save(Shop shop) {
		repo.save(shop);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
