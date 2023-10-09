package org.pedalhub.pedalhubbackend.entities;

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
    @Enumerated(EnumType.STRING)
    private GroupsetMake make;
    @Column
    @Enumerated(EnumType.STRING)
    private GroupsetType type;

    public Groupset() {
    }

    public Groupset(String name, GroupsetMake make, GroupsetType type) {
        this.name = name;
        this.make = make;
        this.type = type;
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

    public GroupsetMake getMake() {
        return make;
    }

    public void setMake(GroupsetMake make) {
        this.make = make;
    }

    public GroupsetType getType() {
        return type;
    }

    public void setType(GroupsetType type) {
        this.type = type;
    }

    @Override
    public String   toString() {
        return "Groupset{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make=" + make +
                ", type=" + type +
                '}';
    }
}
