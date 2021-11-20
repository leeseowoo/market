package me.seowoo.market.service;

import lombok.RequiredArgsConstructor;
import me.seowoo.market.dto.*;
import me.seowoo.market.entity.Category;
import me.seowoo.market.entity.Product;
import me.seowoo.market.repository.CategoryRepository;
import me.seowoo.market.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    // 상품 상세 조회
    public ProductDetailResponseDto getProductDetail(ProductDetailRequestDto productDetailRequestDto) {
        ProductDetailResponseDto test = productRepository.findById(productDetailRequestDto.getProductId()).map(ProductDetailResponseDto::new).get();


//        Optional<Product> product = productRepository.findById(productDetailRequestDto.getProductId());
        return test;
    }


    // 상위 카테고리에 포함된 모든 상품 조회
    public CategoryProductsResponseDto getCategoryProducts(ProductListRequestDto productListRequestDto) {
        return categoryRepository.findById(productListRequestDto.getCategoryId()).map(CategoryProductsResponseDto::new).get();


/*         Optional<Category> test = categoryRepository.findById(productListRequestDto.getCategoryId());

        System.out.println(test.get().getId() + ": " + test.get().getName());
        for (Category c : test.get().getChildren()) {
            System.out.println(c.getId() + ": " + c.getName());
        }
        System.out.println();

        for (Product p : test.get().getProducts()) {
            System.out.println(p.getId() + ": " + p.getName());
        }

        return null;*/
    }


    // 하위 카테고리에 포함된 모든 상품 조회
    public SubCategoryProductsResponseDto getSubCategoryProducts(ProductListRequestDto productListRequestDto) {
        return categoryRepository.findById(productListRequestDto.getCategoryId()).map(SubCategoryProductsResponseDto::new).get();
    }


    // 전체 상품 조회
    public List<ProductsResponseDto> getProducts() {
        List<Product> productEntityList = productRepository.findAll();
        List<ProductsResponseDto> productDtoList = new ArrayList<>();

        for (Product product : productEntityList) {
            productDtoList.add(new ProductsResponseDto(product));
        }

        return productDtoList;
    }
}
