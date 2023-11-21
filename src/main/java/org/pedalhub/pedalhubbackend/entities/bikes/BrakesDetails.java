package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "brakes_details")
public class BrakesDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private Bike bike;
    @Column(length = 900)
    private String brakes;
    @Column(length = 900)
    private String brakeLevers;

    public BrakesDetails() {
    }

    public BrakesDetails(Bike bike, String brakes, String brakeLevers) {
        this.bike = bike;
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
