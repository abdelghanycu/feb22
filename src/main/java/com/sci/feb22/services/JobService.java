package com.sci.feb22.services;

import com.sci.feb22.models.Job;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JobService {

  public List<Job> getJobs() {
    List<Job> res = new ArrayList<>();
    res.add(new Job("s", "sales", 10, 50));
    return res;
  }

  public Job createJob(Job job) {
    return job;
  }

  public Job updateJob(String jobId, Job job) {
    return job;
  }

  public void deleteJob(String jobId) {
  }
}
