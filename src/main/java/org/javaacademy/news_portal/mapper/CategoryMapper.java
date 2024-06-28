package org.javaacademy.news_portal.mapper;

import org.javaacademy.news_portal.dto.CategoryDto;
import org.javaacademy.news_portal.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category convertToDto(CategoryDto dto);
}
