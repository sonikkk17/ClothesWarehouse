package com.cpan228.clothes_warehouse.model.dto;

import com.cpan228.clothes_warehouse.model.ItemModel.FashionBrand;
import lombok.*;

@Data
@NoArgsConstructor
public class SearchModel {
    private FashionBrand brand;
    private int yearOfCreation;
}
