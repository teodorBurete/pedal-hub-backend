package org.pedalhub.pedalhubbackend.entities.dto.brabddto;

public class BrandDto {
    private String description;
    private Long id;
    private String name;
    private String country;

    public BrandDto(Long id, String name, String description, String country) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BrandDto() {
    }
}
