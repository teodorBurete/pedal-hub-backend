package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "brakes_details")
public class BrakesDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;
    @Column
    private String brakes;
    @Column
    private String brakeLevers;

    public BrakesDetails() {
    }

    public BrakesDetails(String brakes, String brakeLevers) {
        this.brakes = brakes;
        this.brakeLevers = brakeLevers;
    }

    public String getBrakes() {
        return brakes;
    }

    public void setBrakes(String brakes) {
        this.brakes = brakes;
    }

    public String getBrakeLevers() {
        return brakeLevers;
    }

    public void setBrakeLevers(String brakeLevers) {
        this.brakeLevers = brakeLevers;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
