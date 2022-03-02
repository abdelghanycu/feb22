package com.sci.feb22.repositories;

import com.sci.feb22.models.Job;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;

public interface JobRep extends CrudRepository<Job, Serializable> {

}
