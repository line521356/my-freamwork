package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "room")
@org.hibernate.annotations.Table(appliesTo = "room", comment = "房间")
public class Room extends BaseModel{

  private static final long serialVersionUID = 3561024310170863462L;

  private String name;
  private Double space;
  private String rentStatus;
  private Date lockEndTime;
  private String identifier;
  private Long edited;
  private String toward;
  private Apartment apartment;
  private Floor floor;
  private Long operatorId;
  private Date canRentDate;
  private Double price;
  private String roomDesc;
  private Long roomType;
  private Long assetsId;
  private Long channelStatus;
  private String remark;
  private Long decoration;
  private String picturesOrder;

}
