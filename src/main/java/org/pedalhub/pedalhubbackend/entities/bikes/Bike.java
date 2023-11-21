package org.pedalhub.pedalhubbackend.entities.bikes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.pedalhub.pedalhubbackend.entities.brands.Brand;
import org.pedalhub.pedalhubbackend.entities.categories.Category;

@Entity
@Table(name = "bikes")
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private Integer year;
    @Column
    private Double price;
    @Column
    private String frameMaterial;
    @Column
    private String wheelSize;
    @Column
    private String groupset;
    @Column
    private String drivetrain;
    @Column
    private String brakesType;
    @Column
    private String suspensionType;
    @Column
    private String fork;
    @Column
    private String frontTravel;
    @Column
    private String rearTravel;
    @ManyToOne
    private Category category;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private DrivetrainDetails drivetrainDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private FrameDetails frameDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private WheelsDetails wheelsDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private BrakesDetails brakesDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private CockpitDetails cockpitDetails;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bike")
    private SeatDetails seatDetails;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public Bike() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFrameMaterial() {
        return frameMaterial;
    }

    public void setFrameMaterial(String frameMaterial) {
        this.frameMaterial = frameMaterial;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(String wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getGroupset() {
        return groupset;
    }

    public void setGroupset(String groupset) {
        this.groupset = groupset;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public void setDrivetrain(String drivetrain) {
        this.drivetrain = drivetrain;
    }

    public String getBrakesType() {
        return brakesType;
    }

    public void setBrakesType(String brakesType) {
        this.brakesType = brakesType;
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    public String getFork() {
        return fork;
    }

    public void setFork(String fork) {
        this.fork = fork;
    }

    public String getFrontTravel() {
        return frontTravel;
    }

    public void setFrontTravel(String frontTravel) {
        this.frontTravel = frontTravel;
    }

    public String getRearTravel() {
        return rearTravel;
    }

    public void setRearTravel(String rearTravel) {
        this.rearTravel = rearTravel;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public DrivetrainDetails getDrivetrainDetails() {
        return drivetrainDetails;
    }

    public void setDrivetrainDetails(DrivetrainDetails drivetrainDetails) {
        this.drivetrainDetails = drivetrainDetails;
    }

    public FrameDetails getFrameDetails() {
        return frameDetails;
    }

    public void setFrameDetails(FrameDetails frameDetails) {
        this.frameDetails = frameDetails;
    }

    public WheelsDetails getWheelsDetails() {
        return wheelsDetails;
    }

    public void setWheelsDetails(WheelsDetails wheelsDetails) {
        this.wheelsDetails = wheelsDetails;
    }

    public BrakesDetails getBrakesDetails() {
        return brakesDetails;
    }

    public void setBrakesDetails(BrakesDetails brakesDetails) {
        this.brakesDetails = brakesDetails;
    }

    public CockpitDetails getCockpitDetails() {
        return cockpitDetails;
    }

    public void setCockpitDetails(CockpitDetails cockpitDetails) {
        this.cockpitDetails = cockpitDetails;
    }

    public SeatDetails getSeatDetails() {
        return seatDetails;
    }

    public void setSeatDetails(SeatDetails seatDetails) {
        this.seatDetails = seatDetails;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
