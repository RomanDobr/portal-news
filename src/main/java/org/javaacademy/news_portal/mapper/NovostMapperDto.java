package org.javaacademy.news_portal.mapper;

import org.javaacademy.news_portal.dto.CreateNovostDto;
import org.javaacademy.news_portal.entity.Category;
import org.javaacademy.news_portal.entity.Novost;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface NovostMapperDto {
    @Mapping(target = "category", source = "category", qualifiedByName = "createCategory")
    Novost convertToEntity(CreateNovostDto dto);

    @Named("createCategory")
    default Category createCategory(String name) {
        return Category.builder().name(name).build();
    }
}
