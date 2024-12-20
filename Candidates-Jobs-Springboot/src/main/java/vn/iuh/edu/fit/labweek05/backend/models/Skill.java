package vn.iuh.edu.fit.labweek05.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.iuh.edu.fit.labweek05.backend.enums.SkillType;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;

    @Column(name = "skill_description")
    private String skillDescription;

    @Column(name = "skill_name")
    private String skillName;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SkillType type;

    public Skill(String skillName, SkillType type, String skillDescription) {
        this.skillName = skillName;
        this.type = type;
        this.skillDescription = skillDescription;
    }
}