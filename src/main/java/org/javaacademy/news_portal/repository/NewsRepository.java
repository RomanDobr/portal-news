package org.javaacademy.news_portal.repository;

import org.javaacademy.news_portal.entity.Novost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<Novost, Long> {
    List<Novost> findAllByDate(LocalDate date);

    Optional<Novost> findAllByDateAndId(LocalDate date, Long id);

}
