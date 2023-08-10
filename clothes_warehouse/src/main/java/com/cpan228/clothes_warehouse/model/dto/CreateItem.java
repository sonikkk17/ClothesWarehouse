package com.cpan228.clothes_warehouse.model.dto;

import com.cpan228.clothes_warehouse.model.ItemModel;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateItem {
    @NotBlank
    private String name;

    @Min(2022)
    private int yearOfCreation;

    @DecimalMin(value = "1000.1", inclusive = true)
    @NotNull
    private BigDecimal price;

    @NotNull
    private ItemModel.FashionBrand brand;

    public ItemModel toItem() {
        return ItemModel.builder()
                .name(this.getName())
                .yearOfCreation(this.getYearOfCreation())
                .price(this.getPrice())
                .brand(this.getBrand())
                .build();
    }
}
