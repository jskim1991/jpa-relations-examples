package io.jay.jpastudy.chapter5.manytoone.bidirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
@Rollback(value = false)
public class RelationTests {

    @Autowired
    private EntityManager em;

    @BeforeEach
    void setup() {
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

        em.flush();
        em.clear();
    }

    @Test
    void test_bidirection() {
        TeamTwo team = em.find(TeamTwo.class, "team1");
        List<MemberTwo> members = team.getMembers();


        assertThat(members.size(), equalTo(2));
    }
}
