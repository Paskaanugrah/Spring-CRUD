package com.paskaaa.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paskaaa.SpringProject.entity.Factory;

@Repository
public interface FactoryRepository extends JpaRepository<Factory, Integer>{

}
