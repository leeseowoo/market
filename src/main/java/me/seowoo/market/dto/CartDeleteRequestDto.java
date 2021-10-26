package me.seowoo.market.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CartDeleteRequestDto {

    private List<Integer> cartIds = new ArrayList<>();
}
