package me.seowoo.market.dto;

import lombok.Getter;
import me.seowoo.market.entity.Product;

@Getter
public class ProductDetailResponseDto {

    private int productId;

    private String name;

    private int price;

    private int quantity;

    public ProductDetailResponseDto(Product product) {
        this.productId = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
