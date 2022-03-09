package com.sci.feb22.services;

import com.sci.feb22.dto.request.EmployeeRequest;
import com.sci.feb22.dto.response.EmployeeAttributesResponse;
import com.sci.feb22.dto.response.EmployeeResponse;
import com.sci.feb22.exceptions.CustomException;
import com.sci.feb22.models.Employee;
import com.sci.feb22.repositories.EmployeeRep;
import java.util.Date;
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

  public Employee createEmployee(EmployeeRequest employeeRequest) throws CustomException {

    Employee employee = new Employee();

    employee.setSalary(employeeRequest.getSalary());
    employee.setHireDate(new Date());
    employee.setEmail(employeeRequest.getEmail());
    employee.setManagerId(employeeRequest.getManagerId());
    employee.setDepartmentId(employeeRequest.getDepartmentId());
    employee.setCommissionPct(employeeRequest.getCommissionPct());
    employee.setLastName(employeeRequest.getLastName());
    employee.setFirstName(employeeRequest.getFirstName());
    employee.setJobId(employeeRequest.getJobId());

    try {
      employee = employeeRep.save(employee);
    }catch (Exception ex) {
      throw new CustomException("you send email exist");
    }

    return employee;
  }

  public Employee updateEmployee(Integer empId, Employee employee) {
    Employee emp = employeeRep.findByEmployeeId(empId);
    if (emp == null) {
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

  public EmployeeResponse getEmployee(Integer empId) {
    Employee employee = employeeRep.findByEmployeeId(empId);
    return new EmployeeResponse(employee.getEmployeeId(),
        new EmployeeAttributesResponse(employee.getFirstName(), employee.getLastName(),
            employee.getEmail(), employee.getPhoneNumber(), employee.getHireDate(),
            employee.getJobId()));
  }

  public List<Employee> getEmployeeByJobId(String jobId) {
    return employeeRep.findByJobId(jobId);
  }
}
