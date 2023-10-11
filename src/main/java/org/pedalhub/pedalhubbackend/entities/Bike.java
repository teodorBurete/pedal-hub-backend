package org.pedalhub.pedalhubbackend.entities;

import jakarta.persistence.*;
import org.pedalhub.pedalhubbackend.entities.enums.bike.BrakesType;
import org.pedalhub.pedalhubbackend.entities.enums.bike.FrameMaterial;
import org.pedalhub.pedalhubbackend.entities.enums.bike.SuspensionType;

@Entity
@Table(name = "bikes")
public class Bike {
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
    @Enumerated(EnumType.STRING)
    private FrameMaterial frameMaterial;
    @Column
    @Enumerated(EnumType.STRING)
    private BrakesType brakesType;
    @Column
    @Enumerated(EnumType.STRING)
    private SuspensionType suspensionType;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Groupset groupset;

    public Bike() {
    }

    public Bike(String name, Integer year, Double price, FrameMaterial frameMaterial, BrakesType brakesType, SuspensionType suspensionType, Groupset groupset) {
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

    public FrameMaterial getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(FrameMaterial frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public BrakesType getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(BrakesType brakesType) {
        this.brakesType = brakesType;
    }

    public SuspensionType getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(SuspensionType suspensionType) {
        this.suspensionType = suspensionType;
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


}
