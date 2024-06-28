package org.javaacademy.news_portal.controller;

import lombok.RequiredArgsConstructor;
import org.javaacademy.news_portal.dto.CreateNovostDto;
import org.javaacademy.news_portal.service.NewsPortalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsPortalController {
    private final NewsPortalService newsPortalService;
    @PostMapping
    public ResponseEntity<?> createNovost(@RequestBody CreateNovostDto dto) {
        newsPortalService.createNovost(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/findAllNews")
    public ResponseEntity<List<CreateNovostDto>> findAllNews(@RequestParam LocalDate date) {
        List<CreateNovostDto> allNews = newsPortalService.findAllNews(date);
        return ResponseEntity.ok().body(allNews);
    }

    @GetMapping("/findAllNewsByDataAndCategory")
    public ResponseEntity<List<CreateNovostDto>> findAllNewsByDataAndCategory(@RequestParam LocalDate date,
                                                                              @RequestParam String name) {
        List<CreateNovostDto> allNews = newsPortalService.findNews(date, name);
        return ResponseEntity.ok().body(allNews);
    }
}
