package vn.iuh.edu.fit.labweek05;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.iuh.edu.fit.labweek05.backend.enums.SkillLevel;
import vn.iuh.edu.fit.labweek05.backend.enums.SkillType;
import vn.iuh.edu.fit.labweek05.backend.models.*;
import vn.iuh.edu.fit.labweek05.backend.repositories.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
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

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private CandidateSkillRepository candidateSkillRepository;

    @Autowired
    private JobSKillRepository jobSKillRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Bean
    CommandLineRunner initData(){
        return args -> {

//  Fake data candidateRepository
//            Random rnd = new Random();
//            for(int i = 1; i < 10; i++) {
//                String number = rnd.nextInt(70000,80000)+"";
//                String zipcode = (CountryCode.VN)+"";
//                Address address = new Address((long) i, "Quang Trung", "HCM", (short)1, number, zipcode);
//                addressRepository.save(address);
//
//                Candidate can = new Candidate(
//                        (long) i,
//                        LocalDate.of(1998, rnd.nextInt(1, 13), rnd.nextInt(1, 29)),
//                        "email" + i + "@gmail.com",
//                        "Name #" + i,
//                        rnd.nextLong(1111111111L, 9999999999L)+"",
//                        address, new LinkedHashSet<>(), new LinkedHashSet<>());
//                candidateRepository.save(can);
//                System.out.println("Added: " + can);
//            }

//  Fake data jobRepository
//            Random rnd = new Random();
//            for(int i = 1 ; i <= 9; i++)
//            {
//                String number = rnd.nextInt(70000,80000)+"";
//                String zipcode = (CountryCode.VN)+"";
//                Optional<Address> address = addressRepository.findById((long)i);
//
//                Company company = new Company((long)i, "about"+i, "email"+i, "comp_name"+i, "phone"+i, "web_url"+i, address.get());
//                companyRepository.save(company);
//                Job job = new Job((long)i, "jobDesc"+i, "jobName"+i, company);
//                jobRepository.save(job);
//            }

//  Fake data experience
//            Random rand = new Random();
//            for(int i = 1; i <= 10; i++)
//            {
//                String companyName = "Company " + i;
//                int year = rand.nextInt(8) + 2018;
//                int month = rand.nextInt(12) + 1;
//                int day = rand.nextInt(28) + 1;
//                LocalDate from_date = LocalDate.of(year, month, day);
//                int newYear = rand.nextInt(8) + 2025;
//                LocalDate to_date = LocalDate.of(newYear, month, day);
//                String role = "role" + i;
//                String workDescription = "Description " + i;
//                Long candidateid = rand.nextLong(9) + 1;
//                Candidate candidate = candidateRepository.findById(candidateid).orElse(null);
//                Experience experience = new Experience((long)i, to_date, candidate, from_date, companyName, role, workDescription);
//                experienceRepository.save(experience);
//            }

 //  Fake data jobSKillRepository
//            Random rnd = new Random();
//            for(int i = 1; i <= 10; i++)
//            {
//                String more_infos = "more_infos"+i;
//                SkillLevel skillLevel = SkillLevel.values()[new Random().nextInt(SkillLevel.values().length)];
//                Long skillid = rnd.nextLong(9) + 1;
//                Long jobid = rnd.nextLong(9) + 1;
//                Skill skill = skillRepository.findById(skillid).get();
//                Job job = jobRepository.findById(jobid).get();
//                JobSkillId jobSkillId = new JobSkillId(jobid, skillid);
//                JobSkill jobSkill = new JobSkill(jobSkillId, job, skill, more_infos, skillLevel);
//                jobSKillRepository.save(jobSkill);
//            }

//  Fake data candidateSkillRepository
//            Random rnd = new Random();
//            for(int i = 1; i <= 10; i++)
//            {
//                String more_infos = "more_infos"+i;
//                SkillLevel skillLevel = SkillLevel.values()[new Random().nextInt(SkillLevel.values().length)];
//                Long skillid = rnd.nextLong(9) + 1;
//                Long candidateid = rnd.nextLong(9) + 1;
//                Skill skill = skillRepository.findById(skillid).get();
//                Candidate candidate = candidateRepository.findById(candidateid).get();
//                CandidateSkillId candidateSkillId = new CandidateSkillId(candidateid,skillid);
//                CandidateSkill candidateSkill = new CandidateSkill(candidateSkillId, candidate, skill, more_infos, skillLevel);
//                candidateSkillRepository.save(candidateSkill);
//            }

//  Fake data skillRepository
//            for(int i = 1; i < 10; i++)
//            {
//                String description = "description" + i;
//                String skillName = "skill" + i;
//                SkillType skillType = SkillType.values()[new Random().nextInt(SkillType.values().length)];
//                Skill skill = new Skill((long)i, description, skillName, skillType);
//                skillRepository.save(skill);
//            }



        };
    }
}
