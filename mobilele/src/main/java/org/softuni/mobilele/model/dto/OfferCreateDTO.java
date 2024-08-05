package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;

import java.util.Objects;

public final class OfferCreateDTO {
    //TODO: Check Model field
    @NotNull
    @Positive
    private Double price;

    @NotNull
    private EngineType engine;

    @NotNull
    private TransmissionType transmission;

    @NotNull
    @Positive
    private Integer year;

    @NotNull
    @Positive
    private Integer mileage;

    @NotNull
    private String description;

    @NotNull
    private String imageURL;

    @NotNull
    Long modelID;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Long getModelID() {
        return modelID;
    }

    public void setModelID(Long modelID) {
        this.modelID = modelID;
    }
}
