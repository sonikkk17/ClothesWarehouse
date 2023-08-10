package com.cpan228.clothes_warehouse.controller;

import com.cpan228.clothes_warehouse.model.dto.DistributionCentre;
import com.cpan228.clothes_warehouse.model.dto.Search;
import com.cpan228.clothes_warehouse.repository.CentreRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/dc")
@CrossOrigin(origins = "http://localhost:8081")
public class DistributionCentreController {
    private static final int PAGE_SIZE = 2;
    private RestTemplate restTemplate;
    private CentreRepository centreRepository;

    public DistributionCentreController (RestTemplate restTemplate, CentreRepository centreRepository){
        this.restTemplate = restTemplate;
        this.centreRepository=centreRepository;
    }

    @GetMapping
    public String distributionCentres(){
        return "DistributionCentre";
    }

    @ModelAttribute
    public void centreSearch(Model model) {
        model.addAttribute("search", new Search());
    }

    @ModelAttribute("centres")
    public List<DistributionCentre> getDistributionCentre(){
        return Arrays.asList(restTemplate.getForObject("http://localhost:8081/api/dc", DistributionCentre[].class));
    }
    @PostMapping()
    public String getItemsByBrandAndName(@ModelAttribute("search") Search search, Model model){
        model.addAttribute("centres", centreRepository.findByBrandAndName(
                search.getBrand(),
                search.getName()));

        return "distributionSearch";
    }

}
