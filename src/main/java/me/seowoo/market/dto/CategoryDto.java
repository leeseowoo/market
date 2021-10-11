package me.seowoo.market.dto;

import lombok.Getter;
import lombok.Setter;
import me.seowoo.market.entity.Category;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryDto {

    private int id;

    private String name;

    private List<CategoryDto> children = new ArrayList<>();


    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();

        for (Category child : category.getChildren()) {
            this.children.add(new CategoryDto(child.getId(), child.getName(), child.getChildren()));
        }
    }

    public CategoryDto(int id, String name, List<Category> children) {
        this.id = id;
        this. name = name;
    }
}
