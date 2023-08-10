package com.cpan228.clothes_warehouse.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ItemDto {
    public enum FashionBrand {
        BALENCIAGA("Balenciaga"), STONEISLAND("Stone Island"), DIOR("Dior");

        private String brandName;

        private FashionBrand(String brandName) {
            this.brandName = brandName;
        }
        @JsonValue
        public String getBrandName() {
            return brandName;
        }

        @JsonCreator
        public static FashionBrand fromString(String brandname) {
            for (FashionBrand b : FashionBrand.values()) {
                if (b.brandName.equalsIgnoreCase(brandname)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unknown brand name: " + brandname);
        }
    }

    private Long id;
    private String name;
    private FashionBrand brand;
    private int yearOfCreation;
    private BigDecimal price;

    private int quantity;

    private int createdAt=2023;
    @JsonIgnore
    private DistributionCentre distributionCentre;
}
