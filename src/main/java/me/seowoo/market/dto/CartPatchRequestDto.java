package me.seowoo.market.dto;

import lombok.Getter;

@Getter
public class CartPatchRequestDto {

    private int cartId;

    private int quantity;
}
