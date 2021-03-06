package io.jay.jpastudy.practice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    /* No requirement to go from item -> order item
    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems = new ArrayList<>();
     */

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();
}
