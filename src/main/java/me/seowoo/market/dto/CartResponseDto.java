package me.seowoo.market.dto;

import lombok.*;
import me.seowoo.market.entity.Cart;

@Getter
//@NoArgsConstructor
public class CartResponseDto {

    private int cartId;

    private int productId;

    private String name;

    private int price;

    private int quantity;

    public CartResponseDto(Cart cart) {
        this.cartId = cart.getId();
        this.productId = cart.getProduct().getId();
        this.name = cart.getProduct().getName();
        this.price = cart.getProduct().getPrice();
        this.quantity = cart.getQuantity();
    }
}
