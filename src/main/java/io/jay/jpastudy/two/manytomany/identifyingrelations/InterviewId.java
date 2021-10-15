package io.jay.jpastudy.two.manytomany.identifyingrelations;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class InterviewId implements Serializable {
    private Long interviewer;
    private Long applicant;
}
