package vn.iuh.edu.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "job")
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @Column(name = "job_id", nullable = false)
    private Long id;

    @Column(name = "job_desc", nullable = false, length = 2000)
    private String jobDesc;

    @Column(name = "job_name", nullable = false)
    private String jobName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company")
    private Company company;

    @Override
    public String toString() {
        return "Job{" +
                "jobDesc='" + jobDesc + '\'' +
                ", id=" + id +
                ", jobName='" + jobName + '\'' +
                ", company=" + company.getId() +
                '}';
    }
}