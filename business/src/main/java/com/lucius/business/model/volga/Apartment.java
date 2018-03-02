package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Apartment extends BaseModel{


  private static final long serialVersionUID = -4718303573273774183L;
  private String name;
  private String city;
  private String district;
  private String block;
  private String address;
  private long isNew;
  private long isDecorating;
  private java.sql.Date decoratingStartAt;
  private java.sql.Date decoratingEndAt;
  private long floorNum;
  private long floorRoomNum;
  private long roomNum;
  private long operatorId;
  private String area;
  private String remark;
  private String latitude;
  private String longitude;

}
