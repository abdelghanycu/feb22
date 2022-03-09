package com.sci.feb22.repositories;

import com.sci.feb22.models.Employee;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRep extends CrudRepository<Employee, Serializable> {

  Employee findByEmployeeId(Integer id);

  List<Employee> findByJobId(String jobId);

  @Transactional
  void deleteByEmployeeId(Integer id);

  List<Employee> findAll();
}
