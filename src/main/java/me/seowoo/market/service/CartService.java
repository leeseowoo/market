package me.seowoo.market.service;

import lombok.RequiredArgsConstructor;
import me.seowoo.market.dto.CartDeleteRequestDto;
import me.seowoo.market.dto.CartPatchRequestDto;
import me.seowoo.market.dto.CartPostRequestDto;
import me.seowoo.market.dto.CartResponseDto;
import me.seowoo.market.entity.Cart;
import me.seowoo.market.entity.Product;
import me.seowoo.market.repository.CartRepository;
import me.seowoo.market.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public List<CartResponseDto> getCartList() {
        return cartRepository.findCartsByMemberId(SecurityUtil.getCurrentMemberId()).stream().map(CartResponseDto::new).collect(Collectors.toList());
    }

    public void addProductToCart(CartPostRequestDto cartPostRequestDto) {
        long memberId = SecurityUtil.getCurrentMemberId();
        int productId = cartPostRequestDto.getProductId();
        int quantity = cartPostRequestDto.getQuantity();

        Optional<Cart> currentCartProduct = cartRepository.findByMemberIdAndProductId(memberId, productId);

        if (currentCartProduct.isEmpty()) {
            cartRepository.save(Cart.builder()
            .memberId(memberId)
            .product(new Product(productId))
            .quantity(quantity)
            .build());
        } else {
            Cart changedQuantity = currentCartProduct.get();
            changedQuantity.setQuantity(changedQuantity.getQuantity() + quantity);
            cartRepository.save(changedQuantity);
        }
    }

    public void updateProductQuantity(CartPatchRequestDto cartPatchRequestDto) {
        Cart cartProduct = cartRepository.findCartById(cartPatchRequestDto.getCartId());
        cartProduct.setQuantity(cartPatchRequestDto.getQuantity());
        cartRepository.save(cartProduct);
    }

    public void deleteProducts(CartDeleteRequestDto cartDeleteRequestDto) {
        cartRepository.deleteAllById(cartDeleteRequestDto.getCartIds());
    }

    public void emptyCart() {
        cartRepository.deleteAllByMemberId(SecurityUtil.getCurrentMemberId());
    }
}
