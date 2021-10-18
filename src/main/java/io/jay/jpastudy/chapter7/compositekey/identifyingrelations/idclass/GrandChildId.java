package io.jay.jpastudy.chapter7.compositekey.identifyingrelations.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class GrandChildId implements Serializable {
    private ChildId child;
    private String id;
}
