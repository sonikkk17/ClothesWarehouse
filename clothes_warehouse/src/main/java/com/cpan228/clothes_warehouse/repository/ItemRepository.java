package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel.FashionBrand;
import org.springframework.data.repository.CrudRepository;
import com.cpan228.clothes_warehouse.model.ItemModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ItemModel, Long> {
    List<ItemModel> findByBrandAndYearOfCreation(FashionBrand brand, int yearOfCreation);
}
