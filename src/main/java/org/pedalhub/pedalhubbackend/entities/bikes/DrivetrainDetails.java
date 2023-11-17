package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "drivetrain_details")
public class DrivetrainDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;

    @Column
    private String rearDerailleur;
    @Column
    private String frontDerailleur;
    @Column
    private String shiftLevers;
    @Column
    private String cassette;
    @Column
    private String crank;
    @Column
    private String bottomBracket;
    @Column
    private String chain;

    public DrivetrainDetails() {
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
