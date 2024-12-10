package vn.iuh.edu.fit.labweek05.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.backend.repositories.CandidateRepository;
import vn.iuh.edu.fit.labweek05.backend.services.CandidateService;
import vn.iuh.edu.fit.labweek05.backend.models.Candidate;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    CandidateRepository candidateRepository;

    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public Page<Candidate> findAll(int page, String sortField, String sortDirection) {
        Sort sort = Sort.by(sortField);
        sort = sortDirection.equalsIgnoreCase("asc") ? sort.ascending() : sort.descending();

        Pageable pageable = PageRequest.of(page, 10, sort); // 10 là số lượng bản ghi mỗi trang
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Optional<Candidate> findById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate save(long id, Candidate candidateDatils) {
        Candidate candidate = candidateRepository.findById(id);
        if(candidate != null) {
            candidate.setId(id);
            candidate.setAddress(candidateDatils.getAddress());
            candidate.setDob(candidateDatils.getDob());
            candidate.setPhone(candidateDatils.getPhone());
            candidate.setEmail(candidateDatils.getEmail());
            candidate.setFullName(candidateDatils.getFullName());
            candidate.setAddress(candidateDatils.getAddress());

            return candidateRepository.save(candidate);

        }
        return null;
    }



    @Override
    public void delete(Long id) {

    }

    
}
