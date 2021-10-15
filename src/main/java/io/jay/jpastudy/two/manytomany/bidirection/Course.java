package io.jay.jpastudy.two.manytomany.bidirection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    private Long id;

    private String name;

    /* this makes bidirectional */
    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}
