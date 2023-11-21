package org.pedalhub.pedalhubbackend.entities.bikes.dto;

import org.pedalhub.pedalhubbackend.entities.categories.Category;

public class BikeResponse {

    private String name;
    private Double price;
    private Integer year;
    private String brandName;
    private Category category;


    public BikeResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
