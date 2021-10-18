package io.jay.jpastudy;

import io.jay.jpastudy.chapter5.manytoone.bidirection.MemberTwo;
import io.jay.jpastudy.chapter5.manytoone.bidirection.TeamTwo;
import io.jay.jpastudy.chapter6.manytomany.identifyingrelations.Applicant;
import io.jay.jpastudy.chapter6.manytomany.identifyingrelations.Interview;
import io.jay.jpastudy.chapter6.manytomany.identifyingrelations.Interviewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class JpaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class, args);
    }

}

@RestController
@RequestMapping("/test")
class TestController {
    @Autowired
    private EntityManager em;

    @GetMapping("/team/members")
    public List<MemberTwo> members() {
        TeamTwo team1 = em.find(TeamTwo.class, "team1");
        return team1.getMembers();
    }
}

@Component
class ManyToOneTestDataRunner implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) {
        TeamTwo team = TeamTwo.builder()
                .id("team1")
                .name("first team")
                .build();
        em.persist(team);

        MemberTwo firstMember = MemberTwo.builder()
                .id("member1")
                .username("first member")
                .team(team)
                .build();
        em.persist(firstMember);

        MemberTwo secondMember = MemberTwo.builder()
                .id("member2")
                .username("second member")
                .team(team)
                .build();
        em.persist(secondMember);
    }
}

@Component
class ManyToManyTestDataRunner implements CommandLineRunner {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public void run(String... args) {
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
    }
}


















