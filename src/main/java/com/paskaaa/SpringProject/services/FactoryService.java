package com.paskaaa.SpringProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paskaaa.SpringProject.entity.Factory;
import com.paskaaa.SpringProject.repository.FactoryRepository;

@Service
public class FactoryService {
	
	@Autowired
	private FactoryRepository repo;
	
	public List<Factory> listAll() {
		return repo.findAll();
	}
	
	public Factory getById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void save(Factory factory) {
		repo.save(factory);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
