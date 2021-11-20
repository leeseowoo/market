package me.seowoo.market.dto;

import lombok.Getter;

@Getter
public class ProductDto {
    private int id;

    private String name;

    private int price;

    public ProductDto(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}