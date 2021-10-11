package me.seowoo.market.service;

import me.seowoo.market.dto.CategoryDto;
import me.seowoo.market.entity.Category;
import me.seowoo.market.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getCategory() {
        List<Category> categoryEntityList = categoryRepository.findAllWithFetchJoin();
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for (Category category : categoryEntityList) {
            categoryDtoList.add(new CategoryDto(category));
        }

        return categoryDtoList;
    }
}
