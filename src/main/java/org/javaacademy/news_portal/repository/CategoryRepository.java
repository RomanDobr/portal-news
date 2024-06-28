package org.javaacademy.news_portal.repository;

import org.javaacademy.news_portal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findAllById(Long id);
    Optional<List<Category>> findAllByName(String name);
}
