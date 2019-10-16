package com.paskaaa.SpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paskaaa.SpringProject.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
