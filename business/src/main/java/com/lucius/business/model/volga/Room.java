package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "room")
@org.hibernate.annotations.Table(appliesTo = "room", comment = "房间")
public class Room extends BaseModel{

  private static final long serialVersionUID = 3561024310170863462L;

  @Column(name = "name",columnDefinition = "varchar(50) DEFAULT NULL comment '房间名'")
  private String name;

  @Column(name = "space",columnDefinition = "double DEFAULT NULL comment '面积'")
  private Double space;

  @Column(name = "rent_status",columnDefinition = "varchar(20) NOT NULL comment '出租状态,\"empty=未租,rented=已租\"'")
  private String rentStatus;

  @Column(name =  "lock_end_time",columnDefinition = "date DEFAULT NULL comment '是否已锁定'")
  private Date lockEndTime;

  @Column(name =  "identifier",columnDefinition = "vvarchar(5) DEFAULT NULL comment '编号'")
  private String identifier;

  @Column(name =  "edited",columnDefinition = "tinyint(1) NOT NULL comment '是否已编辑'")
  private Long edited;

  @Column(name =  "toward",columnDefinition = "varchar(20) NOT NULL comment '朝向,\"unknown=未知,south=朝南,north=朝北,east=朝东,west=朝西\"'")
  private String toward;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
  @JoinColumn(name = "apartment_id")
  private Apartment apartment;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
  @JoinColumn(name = "floor_id")
  private Floor floor;

  @Column(name =  "operator_id",columnDefinition = "int(11) NOT NULL comment '分配操作权限'")
  private Long operatorId;

  @Column(name =  "can_rent_date",columnDefinition = "date DEFAULT NULL comment '可租日期'")
  private Date canRentDate;

  @Column(name =  "price",columnDefinition = "double DEFAULT NULL comment '价格'")
  private Double price;

  @Column(name =  "room_desc",columnDefinition = "longtext comment '房间描述'")
  private String roomDesc;

  @Column(name =  "room_type",columnDefinition = "smallint(5) unsigned NOT NULL comment '主卧次卧,\"0=主卧,1=次卧\"'")
  private Long roomType;

  @Column(name =  "channel_status",columnDefinition = "smallint(5) unsigned DEFAULT NULL comment '记录发布平台'")
  private Long channelStatus;

  @Column(name =  "remark",columnDefinition = "longtext comment '房间备注'")
  private String remark;

  @Column(name =  "decoration",columnDefinition = "smallint(6) DEFAULT NULL comment '装修情况,\"0=毛坯,1=普通装修,2=精装修,3=豪华装修\"'")
  private Long decoration;

  @Column(name =  "pictures_order",columnDefinition = "varchar(150) DEFAULT NULL comment '图片顺序'")
  private String picturesOrder;

}
