package com.sam.helloworld.controller;


import com.sam.helloworld.model.Comment;
import com.sam.helloworld.model.Movie;
import org.bson.BSONDecoder;
import org.bson.BsonNumber;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.sql.Date;
import java.util.*;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;


    @GetMapping("/all")
    public List<Movie> all() {
        //        Query query = new Query().addCriteria(Criteria.where())
        return mongoTemplate.findAll(Movie.class);
    }

    @GetMapping("/notEnglish")
    public List<Movie> notEnglish() {
        Query query = new Query().addCriteria(Criteria.where("nonEnglish").is(true));
        return mongoTemplate.find(query, Movie.class);
    }

    @PostMapping("/addField")
    public List<Movie> addField() {
        Query query = new Query().addCriteria(Criteria.where("languages").ne("English").exists(true));
        Update update = new Update().set("nonEnglish", true);
        mongoTemplate.updateMulti(query, update, Movie.class);

        List<Movie> listNonEnglishMovies = notEnglish();
        return listNonEnglishMovies;

    }

    @GetMapping("/getAllCrime")
    public List<Movie> getAllCrime() {
        Query query = new Query().addCriteria(
                Criteria.where("genres").is("Crime").andOperator(Criteria.where("genres").size(1)));

        return mongoTemplate.find(query, Movie.class);
    }

    @GetMapping("/get/comments")
    public List<Comment> getAllComments() {
        Calendar myCalendar = new GregorianCalendar(2000, 0, 1);
        Query query = new Query().addCriteria(Criteria.where("date").gt(myCalendar.get(Calendar.YEAR)));

        return mongoTemplate.find(query, Comment.class);
    }

    @GetMapping("/moviesWithComments")
    public List<Movie> moviesWithComments() {
        Query query = new Query().addCriteria(Criteria.where("num_mflix_comments").gt(0));

        return mongoTemplate.find(query, Movie.class);

    }

    @GetMapping("/getCountByYear")
    public Document getCountByYear() {
        GroupOperation groupOperation = new GroupOperation(Fields.fields("year")).count().as("count");

        SortOperation sortOperation = new SortOperation(Sort.by(Sort.Direction.DESC, "count"));

        Aggregation aggregation = newAggregation(groupOperation, sortOperation);

        AggregationResults<Movie> movieAggregationResults = mongoTemplate.aggregate(aggregation, "movies", Movie.class);

        return movieAggregationResults.getRawResults();

    }

    @GetMapping("/sortByRating")
    public List<Movie> sortByRating() {
        Query query = new Query(Criteria.where("imdb.rating").exists(true).ne(null).ne("")).with(
                Sort.by(Sort.Direction.DESC, "imdb" + ".rating"));
        // TODO: Memory limit exceeded when not using projections:
        query.fields().include("imdb").include("title");
        return mongoTemplate.find(query, Movie.class);
    }

    @GetMapping("/getAllGenres")
    public List<String> distinctGenres(){

        Query query = new Query();
        return mongoTemplate.findDistinct(query, "genres", Movie.class, String.class);
    }

    @GetMapping("/countByGenres")
    public void countByGenres(){

//        ProjectionOperation projectionOperation = new ProjectionOperation("")

//        Aggregation aggregation = newAggregation(Aggregation.g)

    }

    @GetMapping("/cleanYear")
    public Collection<Movie> cleanYear(){

        Query query = new Query().addCriteria(Criteria.where("year").not().type(JsonSchemaObject.Type.intType()));

        List<Movie> affectedMovies = mongoTemplate.find(query, Movie.class);
//
//        for(Movie movie : affectedMovies){
//                String strYear =  movie.getYear();
//                int newYear = Integer.parseInt(strYear.replaceAll("[\\D]", "").substring(0,4));
//            Query q = new Query().addCriteria(Criteria.where("_id").is(movie.getId()));
//                Update update = new Update().set("year", newYear);
//                System.out.println(mongoTemplate.updateFirst(q, update, Movie.class));
//        }
//        System.out.println("Done");
//        List<Movie> fixedMovies = mongoTemplate.find(query, Movie.class);

        return affectedMovies;

//        return mongoTemplate.insertAll(affectedMovies);


    }


    @GetMapping("/getIndianMovies")
    public List<Movie> getIndianMovies(){

        Query query = new Query().addCriteria(Criteria.where("countries").all("India").size(1));

        return mongoTemplate.find(query, Movie.class);

    }

    @GetMapping("/countByCountries")
    public Document countByCountries() {
//        ProjectionOperation projectionOperation = new ProjectionOperation(Movie.class);
        UnwindOperation unwindOperation = unwind("countries");
        GroupOperation groupOperation = group(Fields.fields("countries")).count().as("count");
        Aggregation aggregation = newAggregation( unwindOperation,
                groupOperation, new SortOperation(Sort.by(Sort.Direction.DESC, "count")) );

        AggregationResults aggregationResults =  mongoTemplate.aggregate(aggregation, "movies", Movie.class);
//        System.out.println(aggregationResults.getRawResults());
        return aggregationResults.getRawResults();
    }

}
