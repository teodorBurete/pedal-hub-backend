package org.pedalhub.pedalhubbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.pedalhub.pedalhubbackend.entities.enums.bike.BrakesType;
import org.pedalhub.pedalhubbackend.entities.enums.bike.FrameMaterial;
import org.pedalhub.pedalhubbackend.entities.enums.bike.SuspensionType;

@Entity
@Table(name = "bikes")
public class Bike {
    //this is a fucking testaaaaaaaaaaa
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer year;
    @Column
    private Double price;
    @Column
    private String frameMaterial;
    @Column
    private String brakesType;
    @Column
    private String suspensionType;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Column(name = "brand_id", insertable = false, updatable = false)
    private Long brandId;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Groupset groupset;

    public Bike() {
    }

/*    public Bike(String name, Integer year, Double price, FrameMaterial frameMaterial, BrakesType brakesType, SuspensionType suspensionType, Groupset groupset) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.frameMaterial = frameMaterial;
        this.brakesType = brakesType;
        this.suspensionType = suspensionType;
        this.groupset = groupset;
    }*/

    public Bike(String name, Integer year, Double price, String frameMaterial, String brakesType, String suspensionType, Groupset groupset) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.frameMaterial = frameMaterial;
        this.brakesType = brakesType;
        this.suspensionType = suspensionType;
        this.groupset = groupset;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Groupset getGroupset() {
        return groupset;
    }

    public void setGroupset(Groupset groupset) {
        this.groupset = groupset;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public String getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(String brakesType) {
        this.brakesType = brakesType;
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }
}
