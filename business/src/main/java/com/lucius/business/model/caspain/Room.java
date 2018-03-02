package com.lucius.business.model.caspain;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "room")
@org.hibernate.annotations.Table(appliesTo = "room", comment = "房间")
public class Room implements Serializable {
    private static final long serialVersionUID = 9172549400915786105L;
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "identity")
    @Column(length = 32, nullable = false, unique = true, columnDefinition = "int(11) comment '记录主键'")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", columnDefinition = "datetime(6) comment '创建记录时间'", updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", columnDefinition = "datetime(6) comment '更新记录时间'", updatable = false)
    @org.hibernate.annotations.UpdateTimestamp
    private Date updatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "deleted_at", columnDefinition = "datetime(6) comment '删除时间'", updatable = false)
    private Date deletedAt;

    @Column(name = "version", columnDefinition = "int(11) comment '版本号' default '0'")
    private Long version;

    @Column(name = "is_delete", columnDefinition = "tinyint(1) comment '是否被删除' default '0'")
    private Long isDelete;

    @Column(name = "name", columnDefinition = "varchar(50) comment '房间名称'")
    private String name;

    @Column(name = "space", columnDefinition = "double comment '面积'")
    private Double space;

    @Column(name = "rent_status", columnDefinition = "varchar(20) comment '出租状态'")
    private String rentStatus;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lock_end_time", columnDefinition = "date comment '是否已锁定'", updatable = false)
    private Date lockEndTime;

    @Column(name = "identifier", columnDefinition = "varchar(5) comment '编号'")
    private String identifier;

    @Column(name = "edited", columnDefinition = "tinyint(1) comment '是否已编辑'")
    private Long edited;

    @Column(name = "price", columnDefinition = "double comment '价格'")
    private Double price;

    @Column(name = "assets_id", columnDefinition = "int(11) comment ''")
    private Long assetsId;

    @Column(name = "created_by_id", columnDefinition = "int(11) comment '创建人ID'")
    private Long createdById;

    @Column(name = "deleted_by_id", columnDefinition = "int(11) comment '删除人ID'")
    private Long deletedById;

    @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "house_id")
    private House house;

    @Column(name = "updated_by_id", columnDefinition = "int(11) comment '修改人ID'")
    private Long updatedById;

    @Column(name = "pay_method_f", columnDefinition = "int(11) comment '付款方式(付)'")
    private Long payMethodF;

    @Column(name = "pay_method_y", columnDefinition = "int(11) comment '付款方式(压)'")
    private Long payMethodY;

    @Column(name = "toward", columnDefinition = "varchar(20) comment '朝向'")
    private String toward;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "can_rent_date", columnDefinition = "date comment '可租日期'", updatable = false)
    private Date canRentDate;

    @Column(name = "room_desc", columnDefinition = "longtext comment '房间描述'")
    private String roomDesc;

    @Column(name = "room_type", columnDefinition = "smallint(5) comment '主卧次卧(0主卧,1次卧)'")
    private Long roomType;

    @Column(name = "channel_status", columnDefinition = "smallint(5) comment '记录发布平台'")
    private Long channelStatus;

    @Column(name = "remark", columnDefinition = "longtext comment '备注'")
    private String remark;

    @Column(name = "decoration", columnDefinition = "smallint(6) comment '装修情况 '")
    private Long decoration;

    @Column(name = "pictures_order", columnDefinition = "varchar(150) comment ' 图片顺序'")
    private String picturesOrder;

    @Column(name = "synchronous", columnDefinition = "int(11) comment '同步房源'")
    private String synchronous;
}
