package com.vladis1350.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class EntityDTO {
    private Long productId;
    @Id
    @SequenceGenerator(name="category_id", initialValue=11, allocationSize=100)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="category_id")
    private Long categoryId;
    private String name;
    private BigDecimal price;
    private String category;
    private BigDecimal discount;
    private String description;
}
