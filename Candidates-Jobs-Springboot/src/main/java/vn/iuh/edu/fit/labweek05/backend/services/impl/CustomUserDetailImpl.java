package vn.iuh.edu.fit.labweek05.backend.services.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.configs.CustomUserDetails;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;
import vn.iuh.edu.fit.labweek05.backend.models.Company;
import vn.iuh.edu.fit.labweek05.backend.models.User;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.CompanyRepository;
import vn.iuh.edu.fit.labweek05.backend.repositories.UserRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailImpl implements UserDetailsService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tìm người dùng qua email từ Candidate hoặc Company
        User user = null;
        Candidate candidate = candidateRepository.findByEmail(email);
        Company company = companyRepository.findByEmail(email);

        if(candidate != null){
            user = userRepository.findByCandidate(candidate);
        }
        else if(company != null){
            user = userRepository.findByCompany(company);
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        // Check roles associated with the user
        Collection<? extends GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())) // Assuming 'role.getName()' returns the role name as a string
                .collect(Collectors.toList());
        // Chuyển đổi thành CustomUserDetails
        return new CustomUserDetails(user, authorities);
    }
}

