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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
