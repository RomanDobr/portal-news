package org.javaacademy.news_portal.service;

import lombok.RequiredArgsConstructor;
import org.javaacademy.news_portal.dto.CreateNovostDto;
import org.javaacademy.news_portal.entity.Category;
import org.javaacademy.news_portal.entity.Novost;
import org.javaacademy.news_portal.mapper.NovostMapperDto;
import org.javaacademy.news_portal.repository.CategoryRepository;
import org.javaacademy.news_portal.repository.NewsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsPortalService {
    private final NewsRepository newsRepository;
    private final NovostMapperDto novostMapperDto;
    private final CategoryRepository categoryRepository;

    public void createNovost(CreateNovostDto dto) {
        Novost novost = novostMapperDto.convertToEntity(dto);
        Category category = novost.getCategory();
        novost.setCategory(category);
        category.setNews(List.of(novost));
        categoryRepository.save(category);
        newsRepository.save(novost);
    }

    @Transactional(readOnly = true)
    public List<CreateNovostDto> findAllNews(LocalDate date) {
        return newsRepository.findAllByDate(date)
        .stream()
        .map(novost -> {
            Category category = categoryRepository.findAllById(novost.getId()).orElseThrow();
            return CreateNovostDto.builder()
                    .title(novost.getTitle())
                    .date(novost.getDate())
                    .text(novost.getText())
                    .category(category.getName())
                    .build();
        }).toList();
    }

    public List<CreateNovostDto> findNews(LocalDate date, String name) {
        return categoryRepository
            .findAllByName(name)
            .orElseThrow()
            .stream().map(category -> {
            Novost novost = newsRepository.findAllByDateAndId(date, category.getId()).orElseThrow();
                    return CreateNovostDto.builder()
                            .title(novost.getTitle())
                            .text(novost.getText())
                            .date(date)
                            .category(name)
                            .build();
            }).toList();
    }
}
