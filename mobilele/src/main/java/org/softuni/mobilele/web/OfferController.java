package org.softuni.mobilele.web;

import jakarta.validation.Valid;
import org.softuni.mobilele.model.dto.OfferCreateDTO;
import org.softuni.mobilele.model.enums.CategoryType;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;
import org.softuni.mobilele.service.BrandService;
import org.softuni.mobilele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final BrandService brandService;
    private final OfferService offerService;

    public OfferController(BrandService brandService, OfferService offerService) {
        this.brandService = brandService;
        this.offerService = offerService;
    }

    @ModelAttribute("engines")
    public EngineType[] engines() {
        return EngineType.values();
    }

    @ModelAttribute("transmissions")
    public TransmissionType[] transmissions() {
        return TransmissionType.values();
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());

        return "offers";
    }

    @GetMapping("/add")
    public String addOffer(Model model) {
        if (!model.containsAttribute("createOfferDTO")) {
            model.addAttribute("createOfferDTO", new OfferCreateDTO());
        }

        model.addAttribute("brands", brandService.getAllBrands());

        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferCreateDTO offerCreateDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerCreateDTO", offerCreateDTO);
            redirectAttributes
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerCreateDTO", bindingResult);

            return "redirect:/offers/add";
        }

        offerService.createOffer(offerCreateDTO);

        return "redirect:/offers/all";
    }

    @GetMapping("/{id}/details")
    public String getDetails(@PathVariable("id") Long id) {
        return "details";
    }
}
