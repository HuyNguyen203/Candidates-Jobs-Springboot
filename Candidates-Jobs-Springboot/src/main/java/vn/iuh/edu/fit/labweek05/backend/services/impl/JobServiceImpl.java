package vn.iuh.edu.fit.labweek05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.models.Job;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.JobRepository;
import vn.iuh.edu.fit.labweek05.backend.services.JobService;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public Optional<Job> findById(Long id) {
        return jobRepository.findById(id);
    }

    @Override
    public Page<Job> findAll(int page, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(page, 10, sort);
        return jobRepository.findAll(pageable);
    }

    @Override
    public Job save(long id, Job jobDetails) {
        Optional<Job> job = jobRepository.findById(id);
        Job newJob = job.get();
        if(job != null){
            newJob.setId(id);
            newJob.setCompany(jobDetails.getCompany());
            newJob.setJobDesc(jobDetails.getJobDesc());
            newJob.setJobName(jobDetails.getJobName());

            return jobRepository.save(newJob);
        }
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
