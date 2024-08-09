package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

public final class CreateOfferDTO {
    //TODO: Check Model field
    @NotNull(message = "Suggested price is required.")
    @Positive
    private Double price;

    @NotNull(message = "Engine type is required.")
    private EngineType engine;

    @NotNull(message = "Transmission type is required.")
    private TransmissionType transmission;

    @YearNotInTheFuture
    @NotNull(message = "Manufacturing year is required.")
    @Positive
    private Integer year;

    @NotNull(message = "Mileage in kilometers is required.")
    @Positive
    private Integer mileage;

    @NotEmpty(message = "Description is required.")
    private String description;

    @NotEmpty(message = "Vehicle image URL is required.")
    private String imageURL;

    @NotNull(message = "Vehicle model is required.")
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
