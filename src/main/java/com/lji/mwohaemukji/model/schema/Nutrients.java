package com.lji.mwohaemukji.model.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Nutrients
 *
 * @author Lee-Jae-Ik
 * @version 0.1
 * @see
 * @since 2022/12/16
 */
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "nutrients")
public class Nutrients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nutrients_id")
    private Long nutrientsId;

    @Column(name = "nutrients_name")
    private String nutrientsName;

    @Column(name = "nutrients_description", nullable = true, length = 255)
    private String nutrientsDescription;

    @Column(name = "nutrients_precautions", nullable = true, length = 255)
    private String nutrientsPrecautions;
}
