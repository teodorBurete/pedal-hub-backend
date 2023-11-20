package org.pedalhub.pedalhubbackend.entities.bikes.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import org.pedalhub.pedalhubbackend.entities.Category;

public class BikeRequest {

    //BIKE
    private String name;
    private Integer year;
    private Double price;
    private String frameMaterial;
    private String wheelSize;
    private String groupset;
    private String drivetrain;
    private String brakesType;
    private String suspensionType;
    private String fork_short;
    private Double frontTravel;
    private Double rearTravel;
    private String category;
    private Long brandId;
    private Long categoryId;

    //DRIVETRAIN
    private String rearDerailleur;
    private String frontDerailleur;
    private String shiftLevers;
    private String cassette;
    private String crank;
    private String bottomBracket;
    private String chain;

    //FRAME
    private String frame;
    private String fork;
    private String rearSuspension;

    //WHEELS
    private String frontHub;
    private String rearHub;
    private String rims;
    private String spokes;
    private String tires;

    //BRAKES
    private String brakes;
    private String brakeLevers;

    //COCKPIT
    private String stem;
    private String handlebar;

    //SADDLE
    private String saddle;
    private String seatPost;

    public BikeRequest() {
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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

    public String getFork_short() {
        return fork_short;
    }

    public void setFork_short(String fork_short) {
        this.fork_short = fork_short;
    }

    public Double getFrontTravel() {
        return frontTravel;
    }

    public void setFrontTravel(Double frontTravel) {
        this.frontTravel = frontTravel;
    }

    public Double getRearTravel() {
        return rearTravel;
    }

    public void setRearTravel(Double rearTravel) {
        this.rearTravel = rearTravel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getHandlebar() {
        return handlebar;
    }

    public void setHandlebar(String handlebar) {
        this.handlebar = handlebar;
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
}
