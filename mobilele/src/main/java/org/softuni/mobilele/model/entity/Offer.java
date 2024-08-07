package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;

import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String text;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineType engine;

    @NotEmpty
    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @NotNull
    @Column(nullable = false)
    private Integer mileage;

    @NotNull
    @Column(nullable = false)
    private Double price;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransmissionType transmission;

    @NotNull
    @Column(nullable = false)
    private Integer year;

    //TODO: custom validation
    @NotNull
    @Column(nullable = false)
    private Date created;

    @NotNull
    @Column
    private Date modified;

    @OneToOne
    private Model model;

    @ManyToOne
    private User seller;

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
