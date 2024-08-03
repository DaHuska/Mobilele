package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.OfferCreateDTO;
import org.softuni.mobilele.model.entity.Model;
import org.softuni.mobilele.model.entity.Offer;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.repository.ModelRepository;
import org.softuni.mobilele.repository.OfferRepository;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.OfferService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;

    public OfferServiceImpl(OfferRepository offerRepository, CurrentUser currentUser, UserRepository userRepository, ModelRepository modelRepository) {
        this.offerRepository = offerRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public void createOffer(OfferCreateDTO offerCreateDTO) {
        //TODO: Add implementation
        offerRepository.save(map(offerCreateDTO));
    }

    private Offer map(OfferCreateDTO offerCreateDTO) {
        // Optimize repository injections
        User user = userRepository.findByUsername(currentUser.getUsername()).get();
        Model model = modelRepository.findByName(offerCreateDTO.getModel());

        return new Offer()
                .setText(offerCreateDTO.getDescription())
                .setEngine(offerCreateDTO.getEngine())
                .setImageURL(offerCreateDTO.getImageURL())
                .setMileage(offerCreateDTO.getMileage())
                .setPrice(offerCreateDTO.getPrice())
                .setTransmission(offerCreateDTO.getTransmission())
                .setYear(offerCreateDTO.getYear())
                .setCreated(new Date())
                .setModified(new Date())
                .setModel(model)
                .setSeller(user);
    }
}
