package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "wheels_details")
public class WheelsDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private Bike bike;

    @Column(length = 900)
    private String frontHub;
    @Column(length = 900)
    private String rearHub;
    @Column(length = 900)
    private String rims;
    @Column(length = 900)
    private String spokes;
    @Column(length = 900)
    private String tires;


    public WheelsDetails() {
    }

    public WheelsDetails(Bike bike, String frontHub, String rearHub, String rims, String spokes, String tires) {
        this.bike = bike;
        this.frontHub = frontHub;
        this.rearHub = rearHub;
        this.rims = rims;
        this.spokes = spokes;
        this.tires = tires;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public String getFrontHub() {
        return frontHub;
    }

    public void setFrontHub(String frontHub) {
        this.frontHub = frontHub;
    }

    public String getRearHub() {
        return rearHub;
    }

    public void setRearHub(String rearHub) {
        this.rearHub = rearHub;
    }

    public String getRims() {
        return rims;
    }

    public void setRims(String rims) {
        this.rims = rims;
    }

    public String getSpokes() {
        return spokes;
    }

    public void setSpokes(String spokes) {
        this.spokes = spokes;
    }

    public String getTires() {
        return tires;
    }

    public void setTires(String tires) {
        this.tires = tires;
    }
}
