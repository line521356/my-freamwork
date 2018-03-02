package com.lucius.business.model.hardware;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <br>
 *
 * @author Lucius
 * create by 2018/2/27
 * @Emial Lucius.li@ixiaoshuidi.com
 */
@Data
@Entity
@Table(name = "ammeter_use_record")
@org.hibernate.annotations.Table(appliesTo = "ammeter_use_record", comment = "电表记录")
public class AmmeterUseRecord extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Column(name = "public_money",columnDefinition = "float(11) comment '公摊使用金额'", scale = 2)
    private Double publicMoney;

    @Column(name = "remain_money",columnDefinition = "float(11) comment '剩余金额'", scale = 2)
    private Double remainMoney;

    @Column(name = "remark",columnDefinition = "varchar(32) comment '备注'")
    private String remark;

    @Column(name = "total_money",columnDefinition = "float(11) comment '总使用金额'", scale = 2)
    private Double totalMoney;

    /**
     * 所属供应商
     */
    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "ammeter_id")
    private Ammeter ammeter;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime comment '更新记录时间'")
    private Date readDate;

    @Column(name = "using_before",columnDefinition = "float(11) comment '使用前金额'", scale = 2)
    private Double usingBefore;

    @Column(name = "using_money",columnDefinition = "float(11) comment '使用金额'", scale = 2)
    private Double usingMoney;




}
