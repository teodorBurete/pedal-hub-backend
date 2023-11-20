package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "cockpit_details")
public class CockpitDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;
    @Column
    private String stem;
    @Column
    private String handlebar;

    public CockpitDetails() {
    }

    public CockpitDetails(String stem, String handlebar) {
        this.stem = stem;
        this.handlebar = handlebar;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getHandlebar() {
        return handlebar;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
