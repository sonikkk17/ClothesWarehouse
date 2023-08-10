package com.cpan228.clothes_warehouse.controller;

import com.cpan228.clothes_warehouse.model.dto.SearchModel;
import com.cpan228.clothes_warehouse.repository.ItemRepository;
import com.cpan228.clothes_warehouse.repository.ItemRepositoryPaginated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/itemlist")
public class ItemListController {
    private static final int PAGE_SIZE = 5;
    private ItemRepository itemRepository;

    private ItemRepositoryPaginated itemRepositoryPaginated;

    public ItemListController(ItemRepository itemRepository, ItemRepositoryPaginated itemRepositoryPaginated){
        this.itemRepository = itemRepository;
        this.itemRepositoryPaginated = itemRepositoryPaginated;
    }

    @Autowired
    private ItemRepository fighterRepository;

    @GetMapping
    public String showItems(Model model){
        return "ItemList";
    }

    @ModelAttribute
    public void items(Model model){
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("items", itemPage);
        model.addAttribute("currentPage", itemPage.getNumber());
        model.addAttribute("totalPages", itemPage.getTotalPages());
    }

    @ModelAttribute
    public void itemSearch(Model model) {
        model.addAttribute("searchModel", new SearchModel());
    }

    @PostMapping()
    public String getItemsByName(@ModelAttribute("searchModel") SearchModel searchModel, Model model){
        model.addAttribute("items", itemRepository.findByBrandAndYearOfCreation(
                searchModel.getBrand(),
                searchModel.getYearOfCreation()));

        return "ItemList";
    }

    @GetMapping("/switchPage")
    public String switchPage(Model model, @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "ItemList";
        }
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0), PAGE_SIZE));
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", itemPage.getNumber());
        return "ItemList";
    }

}
