package com.setec.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="SaleDetail")
public class SaleDetail {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade =CascadeType.ALL)
	@JoinColumn(name = "sale_id",nullable = false)
	private Sale sale;
	@Column(name = "qty",nullable = false)
	private int qty;
	@Column(name = "price",nullable = false)
	private double price;
	@Column(name = "total",nullable = false)
	private double total;
	@ManyToOne()
	@JoinColumn(name = "product_id",nullable=false,referencedColumnName = "id")
	private Product product;
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	

}
