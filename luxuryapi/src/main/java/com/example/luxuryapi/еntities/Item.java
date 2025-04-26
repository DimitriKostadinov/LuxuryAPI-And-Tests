package com.example.luxuryapi.еntities;

import jakarta.persistence.*;

@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Long ItemID;

    @Column(name = "Sort")
    private String Sort;

    @Column(name = "Title")
    private String Title;

    @Column(name = "Price")
    private double Price;

    @Column(name = "Color")
    private String Color;

    @Column(name = "Transparency")
    private String Transparency;

    @Column(name = "Weight_g")
    private double Weight_g;

    @Column(name = "Structure")
    private String Structure;

    @Column(name = "Sustainability")
    private String Sustainability;

    @Column(name = "Optical_effect")
    private String Optical_effect;

    @Column(name = "Purity")
    private String Purity;

    @Column(name = "Origins")
    private String Origins;

    @Column(name = "ImagePath")
    private String ImagePath;

    @Column(name = "Stock")
    private int Stock;

    // Each item belongs to one category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_Category_ID", nullable = false)
    private Category category;

    @Column(name = "FK_Category_ID", nullable = false)
    private Long FK_Category_ID;

    public Long getItemID() {
        return ItemID;
    }

    public void setItemID(Long itemID) {
        ItemID = itemID;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getTransparency() {
        return Transparency;
    }

    public void setTransparency(String transparency) {
        Transparency = transparency;
    }

    public double getWeight_g() {
        return Weight_g;
    }

    public void setWeight_g(double weight_g) {
        Weight_g = weight_g;
    }

    public String getStructure() {
        return Structure;
    }

    public void setStructure(String structure) {
        Structure = structure;
    }

    public String getSustainability() {
        return Sustainability;
    }

    public void setSustainability(String sustainability) {
        Sustainability = sustainability;
    }

    public String getOptical_effect() {
        return Optical_effect;
    }

    public void setOptical_effect(String optical_effect) {
        Optical_effect = optical_effect;
    }

    public String getPurity() {
        return Purity;
    }

    public void setPurity(String purity) {
        Purity = purity;
    }

    public String getOrigins() {
        return Origins;
    }

    public void setOrigins(String origins) {
        Origins = origins;
    }

    public String getImagePath() {
        return ImagePath;
    }

    public void setImagePath(String imagePath) {
        ImagePath = imagePath;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }

    public Long getFK_Category_ID() {
        return FK_Category_ID;
    }

    public void setFK_Category_ID(Long FK_Category_ID) {
        this.FK_Category_ID = FK_Category_ID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category; // mappedBy = "category" in class Category
    }

}
