package me.seowoo.market.controller;

import lombok.RequiredArgsConstructor;
import me.seowoo.market.dto.*;
import me.seowoo.market.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ProductDetailResponseDto> showProductDetail(@RequestBody ProductDetailRequestDto productDetailRequestDto) {
        return ResponseEntity.ok(productService.getProductDetail(productDetailRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductsResponseDto>> showProductList() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/list")
    public ResponseEntity<CategoryProductsResponseDto> showCategoryProducts(@RequestBody ProductListRequestDto productListRequestDto) {
        return ResponseEntity.ok(productService.getCategoryProducts(productListRequestDto));
    }

    @GetMapping("/sublist")
    public ResponseEntity<SubCategoryProductsResponseDto> showSubCategoryProducts(@RequestBody ProductListRequestDto productListRequestDto) {
        return ResponseEntity.ok(productService.getSubCategoryProducts(productListRequestDto));
    }
}
