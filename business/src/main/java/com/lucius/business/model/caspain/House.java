package com.lucius.business.model.caspain;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "house")
@org.hibernate.annotations.Table(appliesTo = "house", comment = "房屋")
public class House implements Serializable {
    private static final Long serialVersionUID = 4221723850258448795L;
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

    @Column(name = "city", columnDefinition = "varchar(50) comment '城市'")
    private String city;

    @Column(name = "district", columnDefinition = "varchar(50) comment '区域'")
    private String district;

    @Column(name = "block", columnDefinition = "varchar(50) comment '商圈'")
    private String block;

    @Column(name = "address", columnDefinition = "varchar(100) comment '地址'")
    private String address;

    @Column(name = "area", columnDefinition = "varchar(50) comment '小区'")
    private String area;

    @Column(name = "building_num", columnDefinition = "varchar(50) comment '栋'")
    private String buildingNum;

    @Column(name = "unit_num", columnDefinition = "varchar(50) comment '单元'")
    private String unitNum;

    @Column(name = "floor_num", columnDefinition = "varchar(50) comment '楼'")
    private String floorNum;

    @Column(name = "house_num", columnDefinition = "varchar(50) comment '门牌号'")
    private String houseNum;

    @Column(name = "pay_method_f", columnDefinition = "smallint(5) comment '付款方式(付)'")
    private Long payMethodF;

    @Column(name = "pay_method_y", columnDefinition = "smallint(5) comment ' 付款方式(压)'")
    private Long payMethodY;

    @Column(name = "month_rental", columnDefinition = "double comment '月租金'")
    private Double monthRental;

    @Column(name = "rent_status", columnDefinition = "varchar(10) comment '出租状态'")
    private String rentStatus;

    @Column(name = "is_whole", columnDefinition = "tinyint(1) comment '整租'")
    private Long isWhole;

    @Column(name = "space", columnDefinition = "double comment '面积'")
    private Double space;

    @Column(name = "price", columnDefinition = "double comment '价格'")
    private Double price;

    @Column(name = "assets_id", columnDefinition = "int(11) comment ''")
    private Long assetsId;

    @Column(name = "created_by_id", columnDefinition = "int(11) comment '创建人'")
    private Long createdById;

    @Column(name = "deleted_by_id", columnDefinition = "int(11) comment '删除人'")
    private Long deletedById;

    @Column(name = "house_type_id", columnDefinition = "int(11) comment ''")
    private Long houseTypeId;

    @Column(name = "updated_by_id", columnDefinition = "int(11) comment '修改人'")
    private Long updatedById;

    @Column(name = "is_new", columnDefinition = "tinyint(1) comment '是否是新增加的房源'")
    private Long isNew;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "decorating_end_at", columnDefinition = "date comment '装修结束时间'")
    private Date decoratingEndAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "decorating_start_at", columnDefinition = "date comment '装修开始时间 '")
    private Date decoratingStartAt;

    @Column(name = "is_decorating", columnDefinition = "tinyint(1) comment '是否在装修'")
    private Long isDecorating;

    @Column(name = "is_show", columnDefinition = "tinyint(1) comment '是否在水滴官网展示 '")
    private Long isShow;

    @Column(name = "is_concentrated", columnDefinition = "tinyint(1) comment '集中式?'")
    private Long isConcentrated;

    @Column(name = "room_num", columnDefinition = "smallint(5) comment '房间数'")
    private Long roomNum;

    @Column(name = "total_floor_num", columnDefinition = "varchar(50) comment '总楼层'")
    private String totalFloorNum;

    @Column(name = "is_stop", columnDefinition = "tinyint(1) comment '是否停用'")
    private Long isStop;

    @Column(name = "decorating_fee", columnDefinition = "double comment '装修费'")
    private Double decoratingFee;

    @Column(name = "remark", columnDefinition = "longtext comment '备注'")
    private String remark;


}
