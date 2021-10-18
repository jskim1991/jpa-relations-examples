package io.jay.jpastudy.chapter5.manytoone.unidirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@DataJpaTest
@Rollback(value = false)
public class RelationTests {

    @Autowired
    private EntityManager em;

    @BeforeEach
    void setUp() {
        TeamOne firstTeam = TeamOne.builder()
                .id("team1")
                .name("first team")
                .build();
        em.persist(firstTeam);

        MemberOne firstMember = MemberOne.builder()
                .id("member1")
                .username("first member")
                .team(firstTeam)
                .build();
        em.persist(firstMember);

        MemberOne secondMember = MemberOne.builder()
                .id("member2")
                .username("second member")
                .team(firstTeam)
                .build();
        em.persist(secondMember);
    }

    @Test
    void test_save() {
        MemberOne firstMember = em.find(MemberOne.class, "member1");
        MemberOne secondMember = em.find(MemberOne.class, "member2");


        assertThat(firstMember.getTeam().getId(), equalTo("team1"));
        assertThat(secondMember.getTeam().getId(), equalTo("team1"));
    }

    @Test
    void test_update() {
        TeamOne newTeam = TeamOne.builder()
                .id("team2")
                .name("a new team")
                .build();
        em.persist(newTeam);


        MemberOne member = em.find(MemberOne.class, "member1");
        member.setTeam(newTeam);


        assertThat(member.getTeam().getId(), equalTo("team2"));
    }

    @Test
    void test_deleteTeam() {
        TeamOne team = em.find(TeamOne.class, "team1");
        MemberOne firstMember = em.find(MemberOne.class, "member1");
        MemberOne secondMember = em.find(MemberOne.class, "member2");


        firstMember.setTeam(null);
        secondMember.setTeam(null);
        em.remove(team);
    }
}
