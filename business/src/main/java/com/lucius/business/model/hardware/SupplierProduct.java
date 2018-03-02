package com.lucius.business.model.hardware;


import com.lucius.business.enums.GoodsType;
import com.lucius.business.enums.HardwareType;
import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Data
@Entity
@Table(name = "supplier_product")
@org.hibernate.annotations.Table(appliesTo = "supplier_product", comment = "供应商产品信息")
public class SupplierProduct extends BaseModel {
	private static final long serialVersionUID = 1L;
	/**
	 * 产品名
	 */
	@Column(columnDefinition = "varchar(128) comment '产品名'")
	private String name;

	/**
	 * 商品分类
	 */
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(32) comment '商品分类'")
	private GoodsType goodsType;

	/**
	 * 产品code
	 */
	@Column(columnDefinition = "varchar(128) comment '产品code'", unique = true)
	private String code;

	/**
	 * 供应商产品所属硬件中心的分类
	 */
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "varchar(32) comment '供应商产品所属硬件中心的分类'")
	private HardwareType hardwareType;

	/**
	 * 所属供应商
	 */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "supplierId")
	private Supplier supplier;


	/**
	 * 产品编号
	 */
	@Column(columnDefinition = "varchar(50) comment '产品编号'")
	private String serialNumber;

    /**
     * 备注
	 */
	@Column(columnDefinition = "varchar(128) comment '备注'")
	private String remark;


}
