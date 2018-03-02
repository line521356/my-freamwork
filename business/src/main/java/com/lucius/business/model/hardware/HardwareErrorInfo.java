package com.lucius.business.model.hardware;

import com.lucius.business.enums.AlarmType;
import com.lucius.business.enums.HardwareType;
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
@Table(name = "hardware_error_info")
@org.hibernate.annotations.Table(appliesTo = "hardware_error_info", comment = "硬件设备异常信息")
public class HardwareErrorInfo extends BaseModel{

    private static final long serialVersionUID = -7754439565621416241L;
    /**
     * 所属硬件
     */
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "hardware_id")
    private Hardware hardware;

    /**
     * 硬件设备类型 1、门锁 2、电表 3、其它
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "hardware_type",columnDefinition = "varchar(16) comment '硬件设备类型'")
    private HardwareType hardwareType;

    @Column(name = "dev_id",columnDefinition = "varchar(128) comment '电表的devId'")
    private String devId;

    @Enumerated(EnumType.STRING)
    @Column(name = "alarm_type",columnDefinition = "varchar(16) comment '报警类型'")
    private AlarmType alarmType;
}
