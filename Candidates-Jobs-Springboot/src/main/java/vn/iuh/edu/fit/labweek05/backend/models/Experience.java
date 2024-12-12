package vn.iuh.edu.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Experience")
public class Experience {
    @Id
    private long id;
    private LocalDate toDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    private LocalDate fromDate;
    private String companyName;
    private String role;
    private String workDescription;
}
