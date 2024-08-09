package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.softuni.mobilele.model.enums.CategoryType;
import org.softuni.mobilele.model.validation.DateNotInTheFuture;
import org.softuni.mobilele.model.validation.YearNotInTheFuture;

import java.util.Date;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private CategoryType category;

    @NotEmpty
    @Length(min = 8, max = 512)
    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @Min(1940)
    @NotNull
    @YearNotInTheFuture
    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @NotNull
    @YearNotInTheFuture
    @Column(name = "end_year", nullable = false)
    private Integer endYear;

    @NotNull
    @DateNotInTheFuture
    @Column(nullable = false)
    private Date created;

    @NotNull
    @DateNotInTheFuture
    @Column(nullable = false)
    private Date modified;

    @ManyToOne
    private Brand brand;

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

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
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
