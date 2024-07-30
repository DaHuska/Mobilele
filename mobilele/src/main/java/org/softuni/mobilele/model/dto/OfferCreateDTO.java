package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;

public record OfferCreateDTO(
    @NotNull
    Model model,

    @NotNull
    @Positive
    Double price,

    @NotNull
    EngineType engine,

    @NotNull
    TransmissionType transmission,

    @NotNull
    @Positive
    Integer year,

    @NotNull
    @Positive
    Integer mileage,

    @NotNull
    String description,

    @NotNull
    String imageURL
) {
}
