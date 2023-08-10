package com.cpan228.clothes_warehouse.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.sun.tools.javac.resources.CompilerProperties.Fragments.Local;

@Data
@Builder
@Table
public class ItemModel {

    @Id
    private Long id;
    @NotBlank
    private String name;
    private FashionBrand brand;

    @Min(value = 2021, message = "Year must be at least 2021")
    private int yearOfCreation;

    @NotNull
    @DecimalMin(value = "1000.0", inclusive = true,message = "Price must be higher than 1000.0")
    private BigDecimal price;
    @NotNull
    private int createdAt;

    public ItemModel() {
      this.createdAt= 2023;
    }

    public ItemModel(Long id,String name, FashionBrand brand, int yearOfCreation, BigDecimal price, int createdAt) {
        this.id = id;
        this.name =name;
        this.brand = brand;
        this.yearOfCreation = yearOfCreation;
        this.price = price;
        this.createdAt = createdAt;
    }

    public enum FashionBrand {
        BALENCIAGA("Balenciaga"), STONE_ISLAND("Stone Island"), DIOR("Dior");

        private String brandName;

        private FashionBrand(String brandName) {
            this.brandName = brandName;
        }

        public String getBrandName() {
            return brandName;
        }

    }
}
