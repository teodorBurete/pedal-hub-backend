package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "frame_details")
public class FrameDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;
    @Column
    private String frame;
    @Column
    private String fork;
    @Column
    private String rearSuspension;

    public FrameDetails() {
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getRearSuspension() {
        return rearSuspension;
    }

    public void setRearSuspension(String rearSuspension) {
        this.rearSuspension = rearSuspension;
    }
}
