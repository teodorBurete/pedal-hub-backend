package org.pedalhub.pedalhubbackend.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.pedalhub.pedalhubbackend.entities.jsonviews.View;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({View.CategoryView.List.class, View.CategoryView.Single.class})
    private Long id;
    @Column
    @JsonView({View.CategoryView.List.class, View.CategoryView.Single.class})
    private String name;
    @Column
    @JsonView({View.CategoryView.Single.class})
    private String description;
    @JsonBackReference(value = "childCategory-parentCategory")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private List<Category> childCategories;
    @ManyToOne
    @JsonManagedReference(value = "childCategory-parentCategory")
    @JoinColumn(name = "parent_id")
    @JsonView({View.CategoryView.Single.class})
    private Category parentCategory;
    @Column(name = "parent_id", insertable = false, updatable = false)
    @JsonView(View.CategoryView.List.class)
    private Long parentId;
    @JsonBackReference(value = "category-bikes")
    @OneToMany(mappedBy = "category")
    private List<Bike> bikeList;

    public Category() {
    }

    public Category(String name, String description, Long parentId) {
        this.name = name;
        this.description = description;
        this.parentId = parentId;
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
