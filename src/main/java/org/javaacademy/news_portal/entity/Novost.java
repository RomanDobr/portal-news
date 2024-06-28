package org.javaacademy.news_portal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Novost {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String title;
    @Column
    private LocalDate date;
    @Column
    private String text;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    @ToString.Exclude
    private Category category;

    public Novost(String title, LocalDate date, String text, Category category) {
        this.title = title;
        this.date = date;
        this.text = text;
        this.category = category;
    }
}
