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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@OneToOne()
	@JoinColumn(name ="product_id",nullable=false,referencedColumnName = "id")
	private Product product;
	@Column(name = "createBy",nullable =false)
	private int createBy;
	@CreationTimestamp()
	@Column(name = "purchaseDate",nullable =false)
	private Date purchaseDate;
	@Column(name = "qty",nullable =false)
	private int qty;
	@Column(name = "cost",nullable =false)
	private double cost;
	@Column(name = "total",nullable =false)
	private double total;
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	 
	
	

}
