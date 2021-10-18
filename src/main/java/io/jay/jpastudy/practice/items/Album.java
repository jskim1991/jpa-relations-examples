package io.jay.jpastudy.practice.items;

import io.jay.jpastudy.practice.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("A")
public class Album extends Item {

    private String artist;
    private String etc;
}
