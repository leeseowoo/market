package me.seowoo.market.dto;

import lombok.Getter;
import me.seowoo.market.entity.Category;
import me.seowoo.market.entity.Product;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryProductsResponseDto {

    private int categoryId;

    private String categoryName;

    private List<CategoryDto> children = new ArrayList<>();

    private List<ProductDto> products = new ArrayList<>();

    public CategoryProductsResponseDto(Category category) {
        this.categoryId = category.getId();
        this.categoryName = category.getName();

        for (Category children : category.getChildren()) {
            this.children.add(new CategoryDto(category));
        }

        for (Product product : category.getProducts()) {
            this.products.add(new ProductDto(product.getId(), product.getName(), product.getPrice()));
        }
    }
}
