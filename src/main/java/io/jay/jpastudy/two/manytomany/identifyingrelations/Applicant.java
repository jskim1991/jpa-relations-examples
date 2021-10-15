package io.jay.jpastudy.two.manytomany.identifyingrelations;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Applicant {

    @Id
    @GeneratedValue
    @Column(name = "APPLICANT_ID")
    private Long id;

    private String name;
}
