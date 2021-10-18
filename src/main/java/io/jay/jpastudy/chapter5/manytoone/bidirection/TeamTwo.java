package io.jay.jpastudy.chapter5.manytoone.bidirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TeamTwo {
    @Id
    private String id;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<MemberTwo> members = new ArrayList<>();
}
