package org.pedalhub.pedalhubbackend.entities.dto;

public class BikeResponse {

    private Long id;
    private String name;
    private Integer year;
    private Double price;
    private String frameMaterial;
    private String brakesType;
    private String suspensionType;
    private Long brandId;
    private Long categoryId;
    private Long groupsetId;

    public BikeResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getGroupsetId() {
        return groupsetId;
    }

    public void setGroupsetId(Long groupsetId) {
        this.groupsetId = groupsetId;
    }
}
