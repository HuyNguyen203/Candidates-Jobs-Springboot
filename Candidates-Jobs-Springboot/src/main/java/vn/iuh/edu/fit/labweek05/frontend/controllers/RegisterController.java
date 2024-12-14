package vn.iuh.edu.fit.labweek05.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.iuh.edu.fit.labweek05.backend.models.*;
import vn.iuh.edu.fit.labweek05.backend.repositories.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/")
    public String register() {
        return "/auth/register";
    }

    @RequestMapping("/candidate")
    public String registerCandidate(@RequestParam("name") String name, @RequestParam("dob") String dob, @RequestParam("email") String email, @RequestParam("phone") String phone, @RequestParam("city") String city, @RequestParam("country") String country, @RequestParam("street") String street, @RequestParam("number") String number, @RequestParam("zipcode") String zipCode, @RequestParam("password") String password, Model model){
        Candidate candidate = new Candidate();
        candidate.setFullName(name);
        candidate.setDob(LocalDate.parse(dob));
        candidate.setEmail(email);
        candidate.setPhone(phone);

        Address address = new Address(city, country, street, number, zipCode);

        try {
            addressRepository.save(address);
            candidate.setAddress(address);
            candidateRepository.save(candidate);

            User user = new User();
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findById(1L).get());
            user.setRoles(roles);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setCandidate(candidate);
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return "/auth/register?fail";
        }
        return "redirect:/register?success";
    }

    @RequestMapping("/company")
    public String registerCompany(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("about") String about, @RequestParam("welUrl") String welUrl, @RequestParam("phone") String phone, @RequestParam("city") String city, @RequestParam("country") String country, @RequestParam("street") String street, @RequestParam("number") String number, @RequestParam("zipcode") String zipCode, @RequestParam("password") String password, Model model){
        Company company = new Company(welUrl, about,phone, email, name);
        Address address = new Address(city, country, street, number, zipCode);

        try {
            addressRepository.save(address);
            company.setAddress(address);
            companyRepository.save(company);

            User user = new User();
            Set<Role> roles = new HashSet<>();
            roles.add(roleRepository.findById(2L).get());
            user.setRoles(roles);
            user.setPassword(bCryptPasswordEncoder.encode(password));
            user.setCompany(company);
            userRepository.save(user);
        }catch (Exception e){
            e.printStackTrace();
            return "/auth/register?fail";
        }
        return "redirect:/register?success";
    }
}
