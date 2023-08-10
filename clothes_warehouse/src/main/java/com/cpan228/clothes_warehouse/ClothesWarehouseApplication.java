package com.cpan228.clothes_warehouse;

import com.cpan228.clothes_warehouse.model.ItemModel;
import com.cpan228.clothes_warehouse.repository.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class ClothesWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesWarehouseApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository){
		return args -> {


			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1500.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Shoes")
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1300.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Heels")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(2100.0))
					.createdAt(2023).build());


			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1450.0))
					.createdAt(2023).build());


			repository.save(ItemModel.builder()
					.name("Pants")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1200.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Hat")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1830.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Long-sleeve")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(1490.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Bag")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(2130.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1050.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Gloves")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(1050.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Boots")
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(2300.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Dress")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1470.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1850.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Bag")
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1650.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Pants")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(1359.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Purse")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1235.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1050.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Gloves")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2023)
					.price(BigDecimal.valueOf(1050.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Boots")
					.brand(ItemModel.FashionBrand.BALENCIAGA)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(2140.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("Heels")
					.brand(ItemModel.FashionBrand.DIOR)
					.yearOfCreation(2021)
					.price(BigDecimal.valueOf(1089.0))
					.createdAt(2023).build());

			repository.save(ItemModel.builder()
					.name("T-Shirt")
					.brand(ItemModel.FashionBrand.STONE_ISLAND)
					.yearOfCreation(2022)
					.price(BigDecimal.valueOf(1050.0))
					.createdAt(2023).build());

		};
	}

}
