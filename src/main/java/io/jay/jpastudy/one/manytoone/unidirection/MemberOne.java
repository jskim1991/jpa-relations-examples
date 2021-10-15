package io.jay.jpastudy.one.manytoone.unidirection;

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
public class MemberOne {
    @Id
    private String id;
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID") /* can be removed */
    private TeamOne team;
}
