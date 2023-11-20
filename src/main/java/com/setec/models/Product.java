package com.setec.models;

import java.util.Date;

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
import jakarta.persistence.Table;

@Entity
@Table(name ="Product")
public class Product {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column(name ="name",unique =true,nullable =false)
	private String name;
	@Column(name ="barcode",unique =true,nullable =false)
	private long barcode;
	@Column(name ="unitPrice",nullable =false)
	private double unitPrice;
	@Column(name ="qtyInstock",nullable =true)
	private int qtyInstock;
	@Column(name ="photo",nullable =true)
	private String photo;
	@ManyToOne()
	@JoinColumn(name ="category_id",nullable =false,referencedColumnName = "id")
	private Category category;
	
	@Column(name = "createBy",nullable =false)
	private int createBy;
	@Column(name = "updateBy",nullable =true)
	private int updateBy;
	@CreationTimestamp()
	@Column(name = "createAt",nullable =false)
	private Date createAt;
	@UpdateTimestamp()
	@Column(name = "updateAt",nullable =true)
	private Date updateAt;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBarcode() {
		return barcode;
	}
	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQtyInstock() {
		return qtyInstock;
	}
	public void setQtyInstock(int qtyInstock) {
		this.qtyInstock = qtyInstock;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public int getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(int updateBy) {
		this.updateBy = updateBy;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	 
	

}
