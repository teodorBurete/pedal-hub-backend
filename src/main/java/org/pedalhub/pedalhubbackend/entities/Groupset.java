package org.pedalhub.pedalhubbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.pedalhub.pedalhubbackend.entities.enums.groupset.GroupsetMake;
import org.pedalhub.pedalhubbackend.entities.enums.groupset.GroupsetType;

@Entity
@Table(name = "groupsets")
public class Groupset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String make;
    @Column
    private String type;
    @Column
    private String line;
    @Column
    private String model;

    public Groupset() {
    }

    public Groupset(String name, String make, String type) {
        this.name = name;
        this.make = make;
        this.type = type;
    }

    public Groupset(String name, String make, String type, String line, String model, String code) {
        this.name = name;
        this.make = make;
        this.type = type;
        this.line = line;
        this.model = model;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Groupset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make=" + make +
                ", type=" + type +
                '}';
    }
}
