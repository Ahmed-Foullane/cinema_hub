package net.ahmed.mapper;

import net.ahmed.DTO.CategoryDTO;
import net.ahmed.entity.Category;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public static Category toEntity(CategoryDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        category.setDescription(dto.getDescription());
        return category;
    }

    public static CategoryDTO fromEntity(Category category) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(category.getName());
        dto.setDescription(category.getDescription());
        if (category.getFilms() != null){
            dto.setFilms(
                    category.getFilms().stream()
                            .map(FilmMapper::fromEntity)
                            .collect(Collectors.toList())
            );
        }
        return dto;
    }

}