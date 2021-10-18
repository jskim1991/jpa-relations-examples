package io.jay.jpastudy.chapter6.manytomany.identifyingrelations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Interviewer {

    @Id
    @GeneratedValue
    @Column(name = "INTERVIEWER_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "interviewer")
    private List<Interview> interviews;
}
