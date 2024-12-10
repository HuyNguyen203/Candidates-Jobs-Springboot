package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CandidateService;
import vn.iuh.edu.fit.labweek05.backend.models.Address;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/list")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateService candidateService;

    @GetMapping("")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateService.findAll());
        return "candidate/list";
    }
    @GetMapping("/candidates")
    public String showCandidatePaging(Model model,
                                      @RequestParam("page")Optional<Integer> page,
                                      @RequestParam("size")Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(
                currentPage - 1, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPages = candidatePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidate/paging";

    }


    @GetMapping("/edit/{id}")
    public String showCandidateItem(@PathVariable Long id, Model model){
        Candidate candidate = candidateService.findById(id).orElse(null);
        if(candidate != null){
            // Định dạng `dob` thành chuỗi 'YYYY-MM-DD' nếu `dob` tồn tại
            LocalDate dob = candidate.getDob();
            String formatDob = dob != null ? dob.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) : "";

            model.addAttribute("candidate", candidate);
            model.addAttribute("date", formatDob);

        }
        return "candidate/update";
    }



    @PostMapping("/edit/{id}")
    public String updateCandidate(@PathVariable Long id, @ModelAttribute("candidate") Candidate candidate){
        Candidate subCandidate = candidateService.findById(id).orElse(null);
        Address address = addressRepository.findById(subCandidate.getAddress().getId()).orElse(null);
        if (candidate.getAddress() != null) {
            address.setStreet(candidate.getAddress().getStreet());
            address.setCity(candidate.getAddress().getCity());
            address.setZipcode(candidate.getAddress().getZipcode());
        } else {
            System.out.println("Address is null!");
        }
        candidate.setAddress(address);
        candidateRepository.save(candidate);

        return "redirect:/list/candidates";  // Nếu không tìm thấy ứng viên, chuyển hướng về danh sách
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
        } else {
            // Log hoặc xử lý nếu cần
            System.out.println("Candidate with id " + id + " does not exist!");
        }
        return "redirect:/list";
    }


}
