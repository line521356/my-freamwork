package com.lucius.business.model.hardware;

import com.lucius.business.enums.AmmeterType;
import com.lucius.business.enums.HardwareElectricitySwitchStatus;
import com.lucius.business.enums.HardwareOnlineStatus;
import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/28
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Data
@Entity
@Table(name = "ammeter",uniqueConstraints = {@UniqueConstraint(columnNames={"dev_id", "version"})})
@org.hibernate.annotations.Table(appliesTo = "ammeter", comment = "电表")
public class Ammeter extends BaseModel{
    private static final long serialVersionUID = 1L;

    /**
     * 电表的devId
     */
    @Column(name = "dev_id",columnDefinition = "varchar(128) comment '电表的devId'")
    private String devId;

    /**
     * 用于线下同步设备devId,线上同步不涉及
     */
    @Column(name = "off_line_syn_code",columnDefinition = "varchar(128) comment '用于线下同步设备devId,线上同步不涉及'", unique = true)
    private String offLineSynCode;

    /**
     * 电表计费单价，多少钱一度电
     */
    @Column(name = "electricity_price",columnDefinition = "float(11) comment '电表计费单价'", scale = 2)
    private Double electricityPrice;

    /**
     * 电表的付费模式,0:后付费；1：预付费
     */
    @Column(name = "pay_mod",columnDefinition = "varchar(8) default 1 comment '电表的付费模式'")
    private String payMod;

    /**
     * 电表的剩余电量
     */
    @Column(name = "electricity_left_value",columnDefinition = "varchar(8)  comment '电表的剩余电量'")
    private String electricityLeftValue;

    /**
     * 公摊值
     */
    @Column(name = "public_num",columnDefinition = "float(11) comment '公摊值'", scale = 2)
    private Double publicNum;
    /**
     * 在线状态 on：在线 off：离线
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "hardware_online_status",columnDefinition = "varchar(16) comment '在线离线'")
    private HardwareOnlineStatus hardwareOnlineStatus;

    /**
     * 电闸状态 on：通电 off：断电
     */
    @Column(name= "hardware_electricity_switch_status",columnDefinition = "varchar(32) comment '通电状态'")
    private HardwareElectricitySwitchStatus hardwareElectricitySwitchStatus;

    /**
     * 安装的时间
     */
    @Column(name =  "install_time",columnDefinition = "datetime comment '安装的时间'")
    private Date installTime;

    /**
     * 分摊比例
     */
    @Column(name = "share",columnDefinition = "float(11) comment '分摊比例'", scale = 2)
    private Double share;

    /**
     * 使用场景 0=公共区域 1=独立公共区域
     */
    @Column(name = "user_case",columnDefinition = "varchar(16) default '1' comment '使用场景 0=公共区域 1=独立公共区域'")
    private String userCase;

    /**
     * 所属供应商
     */
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "supplier_product_id")
    private SupplierProduct supplierProduct;

    /**
     * 所属硬件
     */
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    /**
     * 主表或子表
     */
    @Column(name= "ammeter_type",columnDefinition = "varchar(32) comment '主表或子表'")
    private AmmeterType ammeterType;

    /**
     * 父表
     */
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "parent_ammeter_id")
    private Ammeter parentAmmeter;


}
