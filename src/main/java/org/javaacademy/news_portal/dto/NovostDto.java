package org.javaacademy.news_portal.dto;

import lombok.Data;
import org.javaacademy.news_portal.entity.Category;

import java.time.LocalDate;

@Data
public class NovostDto {
    private Long id;
    private String title;
    private LocalDate date;
    private String text;
    private Category category;
}
