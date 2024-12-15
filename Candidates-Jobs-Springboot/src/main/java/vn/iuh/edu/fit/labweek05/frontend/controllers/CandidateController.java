package vn.iuh.edu.fit.labweek05.frontend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.labweek05.backend.enums.SkillLevel;
import vn.iuh.edu.fit.labweek05.backend.enums.SkillType;
import vn.iuh.edu.fit.labweek05.backend.models.*;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateSkillRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.SkillRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CandidateService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("/home")
    public String home(Model model) {
        return "candidate/home";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        Candidate candidate = new Candidate();
        if(principal instanceof UserDetails) {
            String email = ((UserDetails)principal).getUsername();
            try {
                candidate = candidateRepository.findByEmail(email);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("candidate", candidate);
        return "candidate/profile";
    }

    @GetMapping("/list")
    public String showCandidateList(Model model){
        model.addAttribute("candidates", candidateService.findAll());
        return "candidate/list";
    }
    @GetMapping("/paging")
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
            model.addAttribute("candidate", candidate);
        }
        return "candidate/update";
    }



    @PostMapping("/edit/{id}")
    public String updateCandidate(@PathVariable Long id, @ModelAttribute("candidate") Candidate candidate){
        Candidate subCandidate = candidateService.findById(id).orElse(null);
        Address address = addressRepository.findById(subCandidate.getAddress().getId()).orElse(null);
        if (candidate.getAddress() != null) {
            address.setNumber(candidate.getAddress().getNumber());
            address.setCountry(candidate.getAddress().getCountry());
            address.setStreet(candidate.getAddress().getStreet());
            address.setCity(candidate.getAddress().getCity());
            address.setZipcode(candidate.getAddress().getZipcode());
        } else {
            System.out.println("Address is null!");
        }
        candidate.setAddress(address);
        candidateRepository.save(candidate);

        return "redirect:/candidates/profile";  // Nếu không tìm thấy ứng viên, chuyển hướng về danh sách
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
        } else {
            // Log hoặc xử lý nếu cần
            System.out.println("Candidate with id " + id + " does not exist!");
        }
        return "redirect:/candidates/paging";
    }

    @PostMapping("/addSkill/{id}")
    public String addSkill(@PathVariable Long id, @RequestParam("skillName") String skillName, @RequestParam("type") String type, @RequestParam("skillDescription") String skillDescription, @RequestParam("more") String more, @RequestParam("level") String level, Model model){
        SkillType skillType = SkillType.valueOf(type);
        SkillLevel skillLevel = SkillLevel.valueOf(level);
        Skill skill = new Skill(skillName, skillType, skillDescription);

        Candidate candidate = candidateService.findById(id).orElse(null);
        try {
            skillRepository.save(skill);
            CandidateSkillId candidateSkillId = new CandidateSkillId();
            candidateSkillId.setCanId(candidate.getId());
            candidateSkillId.setSkillId(skill.getId());

            CandidateSkill candidateSkill = new CandidateSkill(candidateSkillId, candidate, skill, more, skillLevel);
            candidateSkillRepository.save(candidateSkill);
        }catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("candidate", candidate);
        return "candidate/profile";
    }


}
