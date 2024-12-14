package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.User;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.UserRepository;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        User user = null;
        Candidate candidate = candidateRepository.findByEmail(email);
        Company company = companyRepository.findByEmail(email);

        if(candidate != null){
            user = userRepository.findByCandidate(candidate);
        }
        else if(company != null){
            user = userRepository.findByCompany(company);
        }
        if(user != null){
            if(user.getPassword().equals(password)){
                model.addAttribute("user", user);
                return "home/index";
            }
            else {
                model.addAttribute("errorPassword", "Sai mật khẩu");
            }
        } else {
            model.addAttribute("errorEmail", "Email không tồn tại");
        }
        return "auth/login";
    }
}
