package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "floor")
@org.hibernate.annotations.Table(appliesTo = "floor", comment = "电表")
public class Floor extends BaseModel{

  private static final long serialVersionUID = -457492934856754082L;

  @Column(name = "num",columnDefinition = "smallint(5) unsigned NOT NULL comment '楼层数'")
  private Long num;

  @Column(name = "name",columnDefinition = "varchar(50) DEFAULT NULL comment '楼层名'")
  private String name;

  @Column(name = "floor_room_num",columnDefinition = "smallint(5) unsigned NOT NULL comment '房间数'")
  private Long floorRoomNum;

  @ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.EAGER,optional = false)
  @JoinColumn(name = "apartment_id")
  private Apartment apartment;

  @Column(name = "operator_id", columnDefinition = "int(11) NOT NULL comment 'operatorId'")
  private Long operatorId;

}
