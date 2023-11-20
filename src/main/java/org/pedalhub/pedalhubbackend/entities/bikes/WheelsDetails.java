package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "wheels_details")
public class WheelsDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;

    @Column
    private String frontHub;
    @Column
    private String rearHub;
    @Column
    private String rims;
    @Column
    private String spokes;
    @Column
    private String tires;


    public WheelsDetails() {
    }

    public WheelsDetails(String frontHub, String rearHub, String rims, String spokes, String tires) {
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
