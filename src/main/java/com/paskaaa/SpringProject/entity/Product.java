package com.paskaaa.SpringProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@ToString
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name")
	private String nama;
	@Column(name = "merk")
	private String merk;
	@Column(name = "madein")
	private String madein;
	@Column(name = "price")
	private Long price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id", referencedColumnName = "id")
	private Shop shop;
	
	public Product() {
		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getMerk() {
		return merk;
	}
	public void setMerk(String merk) {
		this.merk = merk;
	}
	public String getMadein() {
		return madein;
	}
	public void setMadein(String madein) {
		this.madein = madein;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public String toString() {
		return getNama() + " - " + getShop();
	}
}
