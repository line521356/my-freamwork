package com.lucius.business.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lucius.common.support.model.base.BaseModel;

import javax.persistence.*;
import java.util.List;

/**
 * 供应商信息模型
 * 
 * @author zhongqi
 * 
 */
@Entity
@Table(name = "supplier")
@org.hibernate.annotations.Table(appliesTo = "supplier", comment = "供应商信息")
public class Supplier extends BaseModel {
	private static final long serialVersionUID = 1L;

	/**
	 * 供应商名
	 */
	@Column(columnDefinition = "varchar(128) comment '供应商的名字'")
	private String name;

	/**
	 * 供应商code
	 */
	@Column(columnDefinition = "varchar(128) comment '供应商code'")
	private String code;

	/**
	 * 说明描述
	 */
	@Column(columnDefinition = "varchar(128) comment '说明描述'")
	private String description;

//	/**
//	 * 供应商拥有的产品集合
//	 */
//	@OneToMany(mappedBy = "supplier", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
//	private List<SupplierProduct> supplierProducts;
//
//	/**
//	 * 供应商拥有的账号集合
//	 */
//	@OneToMany(mappedBy = "supplier", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
//	private List<SupplierAccount> supplierAccounts;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
