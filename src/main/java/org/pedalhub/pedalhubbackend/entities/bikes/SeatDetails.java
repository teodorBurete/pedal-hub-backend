package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "seat_details")
public class SeatDetails {
    @Id
    @OneToOne
    @JoinColumn(name = "id")
    @JsonIgnore

    private Bike bike;
    @Column(length = 900)
    private String saddle;
    @Column(length = 900)
    private String seatPost;

    public SeatDetails() {
    }

    public SeatDetails(Bike bike, String saddle, String seatPost) {
        this.bike = bike;
        this.saddle = saddle;
        this.seatPost = seatPost;
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
