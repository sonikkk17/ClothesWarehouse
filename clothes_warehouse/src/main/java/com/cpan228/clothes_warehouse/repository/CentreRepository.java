package com.cpan228.clothes_warehouse.repository;

import com.cpan228.clothes_warehouse.model.ItemModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CentreRepository extends CrudRepository<ItemModel, Long> {
    List<ItemModel> findByBrandAndName(ItemModel.FashionBrand brand, String name);
}
