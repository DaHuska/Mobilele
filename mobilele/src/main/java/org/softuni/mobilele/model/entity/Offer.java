package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String text;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    EngineType engine;

    @Column(name = "image_url", nullable = false)
    String imageURL;

    @Column(nullable = false)
    Integer mileage;

    @Column(nullable = false)
    Double price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    TransmissionType transmission;

    @Column(nullable = false)
    Integer year;

    @Column(nullable = false)
    Date created;

    @Column
    Date modified;

    @OneToOne
    Model model;

    @ManyToOne
    User seller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public Offer setText(String text) {
        this.text = text;

        return this;
    }

    public EngineType getEngine() {
        return engine;
    }

    public Offer setEngine(EngineType engine) {
        this.engine = engine;

        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public Offer setImageURL(String imageURL) {
        this.imageURL = imageURL;

        return this;
    }

    public Integer getMileage() {
        return mileage;
    }

    public Offer setMileage(Integer mileage) {
        this.mileage = mileage;

        return this;
    }

    public Double getPrice() {
        return price;
    }

    public Offer setPrice(Double price) {
        this.price = price;

        return this;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public Offer setTransmission(TransmissionType transmission) {
        this.transmission = transmission;

        return this;
    }

    public Integer getYear() {
        return year;
    }

    public Offer setYear(Integer year) {
        this.year = year;

        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Offer setCreated(Date created) {
        this.created = created;

        return this;
    }

    public Date getModified() {
        return modified;
    }

    public Offer setModified(Date modified) {
        this.modified = modified;

        return this;
    }

    public Model getModel() {
        return model;
    }

    public Offer setModel(Model model) {
        this.model = model;

        return this;
    }

    public User getSeller() {
        return seller;
    }

    public Offer setSeller(User seller) {
        this.seller = seller;

        return this;
    }
}
