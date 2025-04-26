package com.example.luxuryapi.еntities;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Category_ID")
    private Long Category_ID;

    @Column(name = "Category_Name", nullable = false)
    private String Category_Name;

    // A Category can have many Items // mappedBy = "category" in class Item -> Category property
    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)

    public Long getCategory_ID() {
        return Category_ID;
    }

    public void setCategory_ID(Long category_ID) {
        Category_ID = category_ID;
    }

    public String getCategory_Name() {
        return Category_Name;
    }

    public void setCategory_Name(String category_Name) {
        Category_Name = category_Name;
    }

    /*1. Role of mappedBy
    mappedBy is set on the inverse side of a two-way association (usually in @OneToMany)
    and specifies the name of the field in the other Entity, through which the relationship
    is already defined.

    Thanks to this, JPA does not create an additional FK column on the inverse side, but
    uses the column defined in the owner side.

    2. Owner side vs. inverse side
    Owner side is the Entity where @ManyToOne + @JoinColumn(name = "...") is present.
    There name specifies the name of the FK column in the table of the owner entity itself.

    The inverse side (where you use mappedBy) does not contain @JoinColumn;
    instead, mappedBy points to the name of the field in the owner entity, without dealing with DB columns.*/

}
