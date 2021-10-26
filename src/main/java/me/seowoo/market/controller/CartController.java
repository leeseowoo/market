package me.seowoo.market.controller;

import lombok.RequiredArgsConstructor;
import me.seowoo.market.dto.CartDeleteRequestDto;
import me.seowoo.market.dto.CartPatchRequestDto;
import me.seowoo.market.dto.CartPostRequestDto;
import me.seowoo.market.dto.CartResponseDto;
import me.seowoo.market.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartResponseDto>> showCartList() {
        return ResponseEntity.ok(cartService.getCartList());
    }

    @PostMapping
    public void addProductToCart(@RequestBody CartPostRequestDto cartPostRequestDto) {
        cartService.addProductToCart(cartPostRequestDto);
    }

    @PatchMapping
    public void changeProductQuantity(@RequestBody CartPatchRequestDto cartPatchRequestDto) {
        cartService.updateProductQuantity(cartPatchRequestDto);
    }

    @DeleteMapping
    public void deleteProducts(@RequestBody CartDeleteRequestDto cartDeleteRequestDto) {
        cartService.deleteProducts(cartDeleteRequestDto);
    }

    @DeleteMapping("/empty")
    public void emptyCart() {
        cartService.emptyCart();
    }
}
