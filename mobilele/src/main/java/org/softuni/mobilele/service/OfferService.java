package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.OfferCreateDTO;
import org.softuni.mobilele.model.entity.Offer;

import java.util.List;

public interface OfferService {
    List<Offer> getAllOffers();
    void createOffer(OfferCreateDTO offerCreateDTO);
}
