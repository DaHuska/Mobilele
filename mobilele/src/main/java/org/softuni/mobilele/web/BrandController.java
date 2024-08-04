package org.softuni.mobilele.web;

import org.softuni.mobilele.model.entity.Brand;
import org.softuni.mobilele.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/brands")
public class BrandController {
    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String allBrands(Model model) {
        List<Brand> brands = brandService.getAllBrands();

        model.addAttribute("brands", brands);

        return "brands";
    }
}
