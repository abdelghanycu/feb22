package com.sci.feb22.controllers;

import com.sci.feb22.models.Job;
import com.sci.feb22.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/job", "/jobs"})
public class JobController {

  @Autowired
  private JobService jobService;

  @GetMapping
  public ResponseEntity<?> getJobs() {
    return new ResponseEntity<>(jobService.getJobs(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createJob(@RequestBody Job job) {
    return new ResponseEntity<>(jobService.createJob(job), HttpStatus.CREATED);
  }

  @PutMapping("/{jobId}")
  public ResponseEntity<?> updateJob(@PathVariable String jobId, @RequestBody Job job) {
    return new ResponseEntity<>(jobService.updateJob(jobId, job), HttpStatus.OK);
  }

  @DeleteMapping("/{jobId}")
  public ResponseEntity<?> deleteJob(@PathVariable String jobId) {
    jobService.deleteJob(jobId);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
