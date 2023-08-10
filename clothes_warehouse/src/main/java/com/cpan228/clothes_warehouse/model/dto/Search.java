package com.cpan228.clothes_warehouse.model.dto;

import com.cpan228.clothes_warehouse.model.ItemModel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Search {
    private ItemModel.FashionBrand brand;
    private String name;
}
