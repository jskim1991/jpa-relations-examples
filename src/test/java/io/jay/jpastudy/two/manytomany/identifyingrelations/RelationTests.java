package io.jay.jpastudy.two.manytomany.identifyingrelations;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.sql.Timestamp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
@Rollback(value = false)
public class RelationTests {

    @Autowired
    private EntityManager em;

    @Test
    void test_read() {
        Interviewer interviewer = Interviewer.builder()
                .name("Sam")
                .build();
        em.persist(interviewer);

        Applicant applicant = Applicant.builder()
                .name("John")
                .build();
        em.persist(applicant);

        Interview interview = new Interview();
        interview.setInterviewer(interviewer);
        interview.setApplicant(applicant);
        interview.setMeetingRoom("EIC Room 11");
        interview.setTime(new Timestamp(System.currentTimeMillis()));
        em.persist(interview);

        em.flush();
        em.clear();

        InterviewId interviewId = new InterviewId();
        interviewId.setInterviewer(1L);
        interviewId.setApplicant(2L);
        Interview search = em.find(Interview.class, interviewId);


        assertThat(search.getApplicant().getName(), equalTo("John"));
        assertThat(search.getInterviewer().getName(), equalTo("Sam"));


        Interviewer returnedInterviewer = em.find(Interviewer.class, 1L);
        assertThat(returnedInterviewer.getInterviews().size(), equalTo(1));
    }
}
