package com.webservice.EcWebService.entity;

import java.util.TreeSet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import jakarta.persistence.criteria.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	@NotBlank(message = "product name can not be blank")
	private String productname;
	private long price;
	@NotBlank(message = "SKU can not be blank")
	private String sku;
	@NotBlank(message = "discription can not be blank")
	@Size(max = 512)
	// @Column(columnDefinition="TEXT",name ="discription" )
	private String discription;
	private String files;
	@Transient
	public String[] filesretrieve;
	private boolean isActive;
	private int stocks;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "catid")
	@JsonBackReference
	private Category category;

	private int createdby;
	private int updatedby;

	/*
	 * @Column
	 *
	 * @ElementCollection(targetClass=String.class) private List<String> sized=new
	 * ArrayList<>();
	 *
	 * @Transient private String[] sizes;
	 */
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String[] getFilesretrieve() {
		return filesretrieve;
	}

	public void setFilesretrieve(String[] filesretrieve) {
		this.filesretrieve = filesretrieve;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getStocks() {
		return stocks;
	}

	public void setStocks(int stocks) {
		this.stocks = stocks;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	

	public int getCreatedby() {
		return createdby;
	}

	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}

	public int getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(int updatedby) {
		this.updatedby = updatedby;
	}

}
