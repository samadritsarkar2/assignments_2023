package com.sam.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor
@Document("movies")
public class Movie<T> {

    @Id
    private String id;

    private String title;
    private List<String> languages;

    private int num_mflix_comments;
    private List<String> genres;
    private List<String > directors;

    private List<String> countries;

    private T imdb;

    private int year;
}
