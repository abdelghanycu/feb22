package com.sci.feb22.dto.response;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse implements Serializable {

  private static final long serialVersionUID = -8717774964305400817L;

  private Integer employeeId;
  private EmployeeAttributesResponse employeeAttributesResponse;


}
