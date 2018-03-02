package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "apartment")
@org.hibernate.annotations.Table(appliesTo = "apartment", comment = "电表")
public class Apartment extends BaseModel{


  private static final long serialVersionUID = -4718303573273774183L;

  @Column(name = "name",columnDefinition = "varchar(50) NOT NULL comment '公寓名称'")
  private String name;

  @Column(name = "city",columnDefinition = "varchar(50) NOT NULL comment '城市'")
  private String city;

  @Column(name = "district",columnDefinition = "varchar(50) NOT NULL comment '地区'")
  private String district;

  @Column(name = "district",columnDefinition = "varchar(50) NOT NULL comment '镇'")
  private String block;

  @Column(name = "address",columnDefinition = "varchar(100) NOT NULL comment '地址'")
  private String address;

  @Column(name = "is_new",columnDefinition = "tinyint(1) NOT NULL comment '是否是新增加的房源'")
  private Long isNew;

  @Column(name = "is_decorating",columnDefinition = "tinyint(1) NOT NULL comment '是否在装修'")
  private Long isDecorating;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "decorating_start_at", columnDefinition = "date comment '装修开始时间 '")
  private Date decoratingStartAt;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "decorating_end_at", columnDefinition = "date comment '装修结束时间'")
  private Date decoratingEndAt;

  @Column(name = "floor_num", columnDefinition = "smallint(5) unsigned NOT NULL comment '总楼层数量'")
  private Long floorNum;

  @Column(name = "floor_room_num", columnDefinition = "smallint(5) unsigned NOT NULL comment '房间数量'")
  private Long floorRoomNum;

  @Column(name = "room_num", columnDefinition = "smallint(5) unsigned NOT NULL comment '房间数量'")
  private Long roomNum;

  @Column(name = "operator_id", columnDefinition = "int(11) NOT NULL comment 'operatorId'")
  private Long operatorId;

  @Column(name = "area", columnDefinition = "varchar(50) NOT NULL comment '区域'")
  private String area;

  @Column(name = "remark", columnDefinition = "longtext comment '备注'")
  private String remark;

  @Column(name = "latitude", columnDefinition = "varchar(30) NOT NULL comment '纬度值'")
  private String latitude;

  @Column(name = "longitude", columnDefinition = "varchar(30) NOT NULL comment '经度值'")
  private String longitude;

}
