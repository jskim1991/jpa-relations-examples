package io.jay.jpastudy.practice.items;

import io.jay.jpastudy.practice.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Item {
    private String director;
    private String actor;
}
