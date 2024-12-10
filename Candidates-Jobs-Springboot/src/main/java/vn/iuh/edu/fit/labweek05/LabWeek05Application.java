package vn.iuh.edu.fit.labweek05;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.iuh.edu.fit.labweek05.backend.models.Address;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.Job;
import vn.iuh.edu.fit.labweek05.backend.repositories.AddressRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.JobRepository;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class LabWeek05Application {

    public static void main(String[] args) {
        SpringApplication.run(LabWeek05Application.class, args);
    }

    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;

    @Bean
    CommandLineRunner initData(){
        return args -> {
//            Random rnd = new Random();
//            for(int i = 1; i < 1000; i++) {
//                String number = rnd.nextInt(70000,80000)+"";
//                String zipcode = (CountryCode.VN)+"";
//                Address address = new Address((long) i, "Quang Trung", "HCM", (short)1, number, zipcode);
//                addressRepository.save(address);
//
//                Candidate can = new Candidate(
//                        (long) i,
//                        LocalDat.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        "email" + i + "@gmail.com",
//                        "Name #" + i,
//                        rnd.nextLong(1111111111L, 9999999999L)+"",
//                        address );
//                candidateRepository.save(can);
//                System.out.println("Added: " + can);
//            }
//            for(int i = 1000 ; i <= 1100; i++)
//            {
//                String number = rnd.nextInt(70000,80000)+"";
//                String zipcode = (CountryCode.VN)+"";
//                Address address = new Address((long) i, "Le Loi", "HCM", (short)1, number, zipcode);
//                addressRepository.save(address);
//
//                Company company = new Company((long)i, "about"+i, "email"+i, "comp_name"+i, "phone"+i, "web_url"+i, address);
//                companyRepository.save(company);
//                Job job = new Job((long)i, "jobDesc"+i, "jobName"+i, company);
//                jobRepository.save(job);
//            }
        };
    }
}
