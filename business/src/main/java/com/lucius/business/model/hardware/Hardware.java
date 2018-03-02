package com.lucius.business.model.hardware;


import com.lucius.business.enums.HardwareStatus;
import com.lucius.business.enums.HardwareType;
import com.lucius.business.enums.HouseStructureType;
import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;


/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Data
@Entity
@Table(name = "hardware")
@org.hibernate.annotations.Table(appliesTo = "hardware", comment = "硬件设备信息模型")
public class Hardware extends BaseModel {


	private static final long serialVersionUID = 2365919365799223721L;

	/**
	 * 房源id
	 */
	@Column(name = "home_id",columnDefinition = "varchar(16) default '1' comment '设备的入住状态'")
	private String homeId;

	/**
	 * 硬件设备类型 1、门锁 2、电表 3、其它
	 */
	@Enumerated(EnumType.STRING)
	@Column(name = "type",columnDefinition = "varchar(16) comment '硬件设备类型'")
	private HardwareType type;


	@Enumerated(EnumType.STRING)
	@Column(name = "house_structure_type",columnDefinition = "varchar(16) comment '集中式或分散式'")
	private HouseStructureType houseStructureType;

}
