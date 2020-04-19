package com.vladis1350.bean;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@EqualsAndHashCode
@ToString
public class Category implements Serializable {
    @Id
    @SequenceGenerator(name="category_id", initialValue=11, allocationSize=100)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_id")
    private Long id;
    private String nameCategory;

    public Category() {
    }

    public Category(String productCategory) {
        this.nameCategory = productCategory;
    }

    public Category(Long id, String productCategory) {
        this.id = id;
        this.nameCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
