package io.jay.jpastudy.chapter7.compositekey.identifyingrelations.idclass;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Parent {

    @Id
    @Column(name = "PARENT_ID")
    private String id;

    private String name;
}
