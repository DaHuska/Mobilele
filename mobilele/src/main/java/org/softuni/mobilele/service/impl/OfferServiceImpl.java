package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.OfferCreateDTO;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public void createOffer(OfferCreateDTO offerCreateDTO) {
        //TODO: Add implementation
    }
}
