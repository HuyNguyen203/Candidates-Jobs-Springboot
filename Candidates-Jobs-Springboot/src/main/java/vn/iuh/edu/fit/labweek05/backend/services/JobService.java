package vn.iuh.edu.fit.labweek05.backend.services;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Job;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public interface JobService {
    List<Job> findAll();
    Optional<Job> findById(Long id);
    Page<Job> findAll(int page, String sortField, String sortDirection);
    Job save(long id, Job job);
    void delete(long id);
}
