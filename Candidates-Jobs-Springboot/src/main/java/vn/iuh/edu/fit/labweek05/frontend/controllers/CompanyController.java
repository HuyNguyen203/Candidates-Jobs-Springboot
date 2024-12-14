package vn.iuh.edu.fit.labweek05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.labweek05.backend.models.Address;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.Job;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CompanyService;
import vn.iuh.edu.fit.labweek05.backend.services.JobService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;



    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("companies", companyRepository.findAll());
        return "company/list";
    }

    @GetMapping("/paging")
    public String paging(Model model,
                         @RequestParam("page")Optional<Integer> page,
                         @RequestParam("size")Optional<Integer> size) {
        int currentPage = page.orElse(1);
        Page<Company> companyPage = companyService.findAll(currentPage - 1, "id", "asc");
        model.addAttribute("companyPage", companyPage);
        int totalPages = companyPage.getTotalPages();
        if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "company/paging";
    }

    @GetMapping("/edit/{id}")
    public String showCompanyItem(@PathVariable Long id, Model model) {
        Optional<Company> company = companyRepository.findById(id);
        if(company != null){
            model.addAttribute("company", company.get());
        }

        return "company/update";
    }

    @PostMapping("/edit/{id}")
    public String updateCompany(@PathVariable Long id, @ModelAttribute Company company) {
        Company subCompany = companyRepository.findById(id).get();
        Address address = addressRepository.findById(subCompany.getAddress().getId()).get();
        if(company.getAddress() != null){
            address.setStreet(company.getAddress().getStreet());
            address.setCity(company.getAddress().getCity());
            address.setZipcode(company.getAddress().getZipcode());
        } else {
            System.out.println("Address is null!");
        }
        company.setAddress(address);
        companyRepository.save(company);

        return "redirect:/companies/paging";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id) {
        if(companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
        } else {
            System.out.println("Company with id " + id + " does not exist!");
        }
        return "redirect:/companies/paging";
    }
}
