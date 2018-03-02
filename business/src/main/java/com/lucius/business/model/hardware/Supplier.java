package com.lucius.business.model.hardware;

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

	

}
