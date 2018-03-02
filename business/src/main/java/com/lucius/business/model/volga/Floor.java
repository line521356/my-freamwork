package com.lucius.business.model.volga;

import com.lucius.common.support.model.base.BaseModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class Floor extends BaseModel{

  private static final long serialVersionUID = -457492934856754082L;
  private Long num;
  private String name;
  private Long floorRoomNum;
  private Apartment apartment;
  private Long operatorId;

}
