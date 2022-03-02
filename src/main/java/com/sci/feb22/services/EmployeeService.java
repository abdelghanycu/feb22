package com.sci.feb22.services;

import com.sci.feb22.models.Employee;
import com.sci.feb22.repositories.EmployeeRep;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRep employeeRep;

  public List<Employee> getEmployees() {
    return employeeRep.findAll();
  }

  public Employee createEmployee(Employee employee) {
    return employeeRep.save(employee);
  }

  public Employee updateEmployee(Integer empId, Employee employee) {
    Employee emp = employeeRep.findByEmployeeId(empId);
    if(emp == null) {
      return null;
    }
    emp.setEmail(employee.getEmail());
//    emp.setCommissionPct(employee.getCommissionPct());
    emp.setDepartmentId(employee.getDepartmentId());
    emp.setHireDate(employee.getHireDate());
    emp.setLastName(employee.getLastName());
    emp.setPhoneNumber(employee.getPhoneNumber());
    emp.setSalary(employee.getSalary());
    emp.setFirstName(employee.getFirstName());
    emp.setJobId(employee.getJobId());
    emp.setManagerId(employee.getManagerId());
    return employeeRep.save(emp);
  }

  public void deleteEmployee(Integer empId) {
    employeeRep.deleteByEmployeeId(empId);
  }

  public Employee getEmployee(Integer empId) {
    return employeeRep.findByEmployeeId(empId);
  }

  public List<Employee> getEmployeeByJobId(String jobId) {
    return employeeRep.findByJobId(jobId);
  }
}
