package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "drivetrain_details")
public class DrivetrainDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore

    private Bike bike;

    @Column(length = 900)
    private String rearDerailleur;
    @Column(length = 900)
    private String frontDerailleur;
    @Column(length = 900)
    private String shiftLevers;
    @Column(length = 900)
    private String cassette;
    @Column(length = 900)
    private String crank;
    @Column(length = 900)
    private String bottomBracket;
    @Column(length = 900)
    private String chain;

    public DrivetrainDetails() {
    }

    public DrivetrainDetails(Bike bike, String rearDerailleur, String frontDerailleur, String shiftLevers, String cassette, String crank, String bottomBracket, String chain) {
        this.bike = bike;
        this.rearDerailleur = rearDerailleur;
        this.frontDerailleur = frontDerailleur;
        this.shiftLevers = shiftLevers;
        this.cassette = cassette;
        this.crank = crank;
        this.bottomBracket = bottomBracket;
        this.chain = chain;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public String getRearDerailleur() {
        return rearDerailleur;
    }

    public void setRearDerailleur(String rearDerailleur) {
        this.rearDerailleur = rearDerailleur;
    }

    public String getFrontDerailleur() {
        return frontDerailleur;
    }

    public void setFrontDerailleur(String frontDerailleur) {
        this.frontDerailleur = frontDerailleur;
    }

    public String getShiftLevers() {
        return shiftLevers;
    }

    public void setShiftLevers(String shiftLevers) {
        this.shiftLevers = shiftLevers;
    }

    public String getCassette() {
        return cassette;
    }

    public void setCassette(String cassette) {
        this.cassette = cassette;
    }

    public String getCrank() {
        return crank;
    }

    public void setCrank(String crank) {
        this.crank = crank;
    }

    public String getBottomBracket() {
        return bottomBracket;
    }

    public void setBottomBracket(String bottomBracket) {
        this.bottomBracket = bottomBracket;
    }

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }
}
