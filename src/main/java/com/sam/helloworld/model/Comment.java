package com.sam.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Document("comments")
public class Comment {

    @Id
    private String id;
    private String name;
    private String text;
    private String movie_id;
}
