package io.jay.jpastudy.chapter6.onetoone.bidirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Locker {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    /* this makes bidirectional */
    @OneToOne(mappedBy = "locker")
    private User user;
}
