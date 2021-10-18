package io.jay.jpastudy.chapter5.manytoone.bidirection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MemberTwo {
    @Id
    private String id;
    private String username;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "TEAM_ID") /* can be removed */
    private TeamTwo team;

    /* recommendation? */
//    public void setTeam(TeamTwo team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }
}
