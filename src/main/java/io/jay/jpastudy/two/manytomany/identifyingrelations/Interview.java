package io.jay.jpastudy.two.manytomany.identifyingrelations;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@IdClass(InterviewId.class)
public class Interview {

    @Id
    @ManyToOne
    @JoinColumn(name = "INTERVIEWER_ID")
    private Interviewer interviewer;

    @Id
    @ManyToOne
    @JoinColumn(name = "APPLICANT_ID")
    private Applicant applicant;

    private String meetingRoom;
    private Timestamp time;
}
