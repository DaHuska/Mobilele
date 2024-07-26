package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;
import org.softuni.mobilele.model.enums.CategoryType;

import java.sql.Date;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Column(nullable = false)
    String name;

    @Enumerated
    @Column(name = "category", nullable = false)
    CategoryType category;

    @Length(min = 8, max = 512)
    @Column(name = "image_url", nullable = false)
    String imageURL;

    @Column(name = "start_year", nullable = false)
    int startYear;

    @Column(name = "end_year", nullable = false)
    int endYear;

    @Column(nullable = false)
    Date created;

    @Column(nullable = false)
    Date modified;

    @ManyToOne
    Brand brand;

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

    public CategoryType getCategoryType() {
        return category;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.category = categoryType;
    }

    public @Length(min = 8, max = 512) String getImageURL() {
        return imageURL;
    }

    public void setImageURL(@Length(min = 8, max = 512) String imageURL) {
        this.imageURL = imageURL;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
