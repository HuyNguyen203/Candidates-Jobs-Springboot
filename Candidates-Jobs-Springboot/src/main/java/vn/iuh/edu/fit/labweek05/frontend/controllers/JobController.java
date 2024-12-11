package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.Job;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.JobRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CompanyService;
import vn.iuh.edu.fit.labweek05.backend.services.JobService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyService companyService;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/list")
    public String showJobList(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "job/list";
    }

    @GetMapping("/paging")
    public String showJobs(Model model,
                           @RequestParam("page")Optional<Integer> page,
                           @RequestParam("size")Optional<Integer> size) {
        int currentPage = page.orElse(1);
        Page<Job> jobPage = jobService.findAll(currentPage - 1, "id", "asc");
        model.addAttribute("jobPage", jobPage);
        int totalPages = jobPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "job/paging";
    }

    @GetMapping("/edit/{id}")
    public String showJobItem(@PathVariable Long id, Model model) {
        Optional<Job> job = jobRepository.findById(id);
        if(job != null){
            model.addAttribute("job", job.get());
        }

        return "job/update";
    }

    @PostMapping("edit/{id}")
    public String editJob(@PathVariable Long id, @ModelAttribute Job job) {
        Job subJob = jobRepository.findById(id).get();
        subJob.setJobName(job.getJobName());
        subJob.setJobDesc(job.getJobDesc());
        jobRepository.save(subJob);

        return "redirect:/jobs/paging";
    }
}
