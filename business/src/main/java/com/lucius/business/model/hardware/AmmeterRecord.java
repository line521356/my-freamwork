package com.lucius.business.model.hardware;

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
@Table(name = "ammeter_record")
@org.hibernate.annotations.Table(appliesTo = "ammeter_record", comment = "电表同步电量记录")
public class AmmeterRecord extends BaseModel {

    private static final long serialVersionUID = -6681215055636185889L;

    @Column(name = "num",columnDefinition = "double comment '电表读数'", scale = 2)
    private Double num;

    @Column(name = "public_num",columnDefinition = "double comment '公摊值'", scale = 2)
    private Double publicNum;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(columnDefinition = "datetime comment '更新记录时间'")
    private Date readDate;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "ammeter_id")
    private Ammeter ammeter;
}
