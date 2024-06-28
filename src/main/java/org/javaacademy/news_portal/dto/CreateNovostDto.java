package org.javaacademy.news_portal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNovostDto {
    private String title;
    private LocalDate date;
    private String text;
    private String category;
}
