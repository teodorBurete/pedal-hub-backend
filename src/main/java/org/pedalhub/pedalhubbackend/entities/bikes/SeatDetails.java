package org.pedalhub.pedalhubbackend.entities.bikes;

import jakarta.persistence.*;

@Entity
@Table(name = "seat_details")
public class SeatDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    private Bike bike;
    @Column
    private String saddle;
    @Column
    private String seatPost;

    public SeatDetails() {
    }

    public String getSaddle() {
        return saddle;
    }

    public void setSaddle(String saddle) {
        this.saddle = saddle;
    }

    public String getSeatPost() {
        return seatPost;
    }

    public void setSeatPost(String seatPost) {
        this.seatPost = seatPost;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }
}
