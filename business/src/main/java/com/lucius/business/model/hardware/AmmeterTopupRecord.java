package com.lucius.business.model.hardware;

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
@Table(name = "ammeter_record")
@org.hibernate.annotations.Table(appliesTo = "ammeter_record", comment = "电表同步电量记录")
public class AmmeterTopupRecord extends BaseModel {

    private static final long serialVersionUID = 3225061981913351263L;

    @Column(columnDefinition = "varchar(128) comment '是否成功'")
    private String isSuccess;

    @Column(name = "money",columnDefinition = "float(11) comment '充值金额'", scale = 2)
    private Double money;

    @Column(columnDefinition = "varchar(128) comment '来源 0=微信,1=管家,2=其他'")
    private String topupResource;

    @Column(columnDefinition = "varchar(128) comment '充值类型 0=电费,1=其他'")
    private String topupType;

    @Column(columnDefinition = "varchar(128) comment '充值后总金额'")
    private String totalMoney;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "ammeter_id")
    private Ammeter ammeter;
}
