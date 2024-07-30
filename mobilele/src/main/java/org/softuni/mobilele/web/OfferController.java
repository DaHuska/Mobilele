package org.softuni.mobilele.web;

import org.softuni.mobilele.model.dto.OfferCreateDTO;
import org.softuni.mobilele.model.enums.CategoryType;
import org.softuni.mobilele.model.enums.EngineType;
import org.softuni.mobilele.model.enums.TransmissionType;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final BrandService brandService;

    public OfferController(BrandService brandService) {
        this.brandService = brandService;
    }

    @ModelAttribute("categories")
    public CategoryType[] categories() {
        return CategoryType.values();
    }

    @ModelAttribute("engines")
    public EngineType[] engines() {
        return EngineType.values();
    }

    @ModelAttribute("transmissions")
    public TransmissionType[] transmissions() {
        return TransmissionType.values();
    }

//    @GetMapping("/add")
//    public String addOffer(Model model) {
//        model.addAttribute("brands", brandService.getAllBrands());
//    }

    @PostMapping("/add")
    public String addOffer(OfferCreateDTO offerCreateDTO) {

        return "offer-add";
    }
}
