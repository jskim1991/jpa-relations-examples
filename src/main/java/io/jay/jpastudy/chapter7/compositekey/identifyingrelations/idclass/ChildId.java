package io.jay.jpastudy.chapter7.compositekey.identifyingrelations.idclass;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ChildId implements Serializable {
    private String parent;
    private String childId;
}
