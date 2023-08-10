package com.cpan228.clothes_warehouse.controller.rest;

import com.cpan228.clothes_warehouse.model.ItemModel;
import com.cpan228.clothes_warehouse.model.dto.CreateItem;
import com.cpan228.clothes_warehouse.repository.ItemRepository;
import com.cpan228.clothes_warehouse.repository.ItemRepositoryPaginated;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/items", produces = "application/json")
public class ItemController {

    private final ItemRepositoryPaginated itemRepositoryPaginated;

    private final ItemRepository itemRepository;

    public ItemController(ItemRepositoryPaginated itemRepositoryPaginated,
                           ItemRepository itemRepository) {
        this.itemRepositoryPaginated = itemRepositoryPaginated;
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public Iterable<ItemModel> allItems(@RequestParam("page") Optional<Integer> page,
                                         @RequestParam("size") Optional<Integer> size) {
        if (!page.isPresent() || !size.isPresent()) {
            return itemRepository.findAll();
        } else {
            return itemRepositoryPaginated.findAll(PageRequest.of(page.get(), size.get()));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable("id") Long id) {
        itemRepository.deleteById(id);
    }

    @PostMapping
    public ItemModel createItem(@Valid @RequestBody CreateItem item) {
        return itemRepository.save(item.toItem());
    }

    @PutMapping("/{id}")
    public ItemModel updateItem(@PathVariable("id") Long id,
                                @Valid @RequestBody CreateItem item) {
        var ItemToUpdate = itemRepository.findById(id).orElseThrow();
        ItemToUpdate.setName(item.getName());
        ItemToUpdate.setYearOfCreation(item.getYearOfCreation());
        ItemToUpdate.setPrice(item.getPrice());
        ItemToUpdate.setBrand(item.getBrand());
        return itemRepository.save(ItemToUpdate);
    }
    
}
