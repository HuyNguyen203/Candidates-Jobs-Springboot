package vn.iuh.edu.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate toDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    private LocalDate fromDate;
    private String companyName;
    private String role;
    private String workDescription;

    public Experience(LocalDate toDate, Candidate candidate, LocalDate fromDate, String companyName, String role, String workDescription) {
        this.toDate = toDate;
        this.candidate = candidate;
        this.fromDate = fromDate;
        this.companyName = companyName;
        this.role = role;
        this.workDescription = workDescription;
    }
}
