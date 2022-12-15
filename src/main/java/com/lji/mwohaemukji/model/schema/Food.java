package com.lji.mwohaemukji.model.schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Food
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/15
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@Entity @Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long foodId;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "food_kilocalories")
    private Float foodKilocalories;

}
