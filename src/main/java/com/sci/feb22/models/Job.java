package com.sci.feb22.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jobs", schema = "hr")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job implements Serializable {

  private static final long serialVersionUID = 2660976628016537646L;

  @Id
  @Column(name = "job_id")
  private String jobId;
  @Column(name = "job_title")
  private String jobTitle;
  @Column(name = "min_salary")
  private Integer minSalary;
  @Column(name = "max_salary")
  private Integer maxSalary;
}
