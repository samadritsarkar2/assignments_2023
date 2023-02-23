package com.sam.helloworld.repository;

import com.sam.helloworld.model.PlayerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class CustomPlayerProfileRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    public PlayerProfile updatePlayerName(int playerId, String newName){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));
        Update updateName = new Update().set("name",newName);

        return mongoTemplate.findAndModify(query, updateName, new FindAndModifyOptions().returnNew(true), PlayerProfile.class);

    }
}
