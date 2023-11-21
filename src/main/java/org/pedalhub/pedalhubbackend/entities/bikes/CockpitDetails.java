package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "cockpit_details")
public class CockpitDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore

    private Bike bike;
    @Column(length = 900)
    private String stem;
    @Column(length = 900)
    private String handlebar;

    public CockpitDetails() {
    }

    public CockpitDetails(Bike bike, String stem, String handlebar) {
        this.bike = bike;
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
