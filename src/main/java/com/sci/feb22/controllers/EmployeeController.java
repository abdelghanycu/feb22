package com.sci.feb22.controllers;

import com.sci.feb22.dto.request.EmployeeRequest;
import com.sci.feb22.exceptions.CustomException;
import com.sci.feb22.models.Employee;
import com.sci.feb22.services.EmployeeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/{empId}")
  public ResponseEntity<?> getEmployee(@PathVariable Integer empId) {
    return new ResponseEntity<>(employeeService.getEmployee(empId), HttpStatus.OK);
  }

  @GetMapping("/get-by-job/{jobId}")
  public ResponseEntity<?> getEmployeeByJobId(@PathVariable String jobId) {
    return new ResponseEntity<>(employeeService.getEmployeeByJobId(jobId), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<?> getEmployees() {
    return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest)
      throws CustomException {
    System.out.println("abdelghany");
    return new ResponseEntity<>(employeeService.createEmployee(employeeRequest),
        HttpStatus.CREATED);
  }

  @PutMapping("/{empId}")
  public ResponseEntity<?> updateEmployee(@PathVariable Integer empId,
      @RequestBody Employee employee) {
    return new ResponseEntity<>(employeeService.updateEmployee(empId, employee), HttpStatus.OK);
  }

  @DeleteMapping("/{empId}")
  public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId) {
    employeeService.deleteEmployee(empId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
