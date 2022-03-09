package com.sci.feb22.dto.request;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest implements Serializable {

  private static final long serialVersionUID = -1048733063026377816L;

  @NotNull(message = "first name should be provided")
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String jobId;
  @Min(value = 0, message = "can not be -ve")
  private Integer salary;
  private Integer commissionPct;
  private Integer managerId;
  private Integer departmentId;
}
