package me.seowoo.market.dto;

import me.seowoo.market.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsResponseDto {

    private List<ProductDto> products = new ArrayList<>();


    public ProductsResponseDto(Product product) {
        this.products.add(new ProductDto(product.getId(), product.getName(), product.getPrice()));
    }
}
