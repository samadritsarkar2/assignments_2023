package com.sam.helloworld.repository;

import com.mongodb.MongoException;
import com.sam.helloworld.model.PlayerProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
@Primary
public class PlayerProfileRepositoryImpl implements PlayerProfileRepository {
    @Autowired
    private MongoTemplate mongoTemplate;


    public PlayerProfile create(PlayerProfile newPlayer) throws MongoException {
        return mongoTemplate.insert(newPlayer);
    }

    public Collection<PlayerProfile> createBulk(List<PlayerProfile> newPlayers){

       return mongoTemplate.insertAll(newPlayers);
    }

    public PlayerProfile getPlayerProfileById(String playerId){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));
        return mongoTemplate.findOne(query, PlayerProfile.class);
    }

    public List<PlayerProfile> getAllPlayerProfiles(){
        return mongoTemplate.findAll(PlayerProfile.class);
    }

    public List<PlayerProfile> searchPlayerProfilesByName(String str){
        Query query = new Query().addCriteria(Criteria.where("name").is(str));
        return mongoTemplate.find(query, PlayerProfile.class);
    }


    public PlayerProfile updatePlayerProfile(String playerId, String field, String newValue){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));
        Update updateField = new Update().set(field ,newValue);

        return mongoTemplate.findAndModify(query, updateField, new FindAndModifyOptions().returnNew(true),
                PlayerProfile.class);

    }

    public PlayerProfile deletePlayerProfile(String playerId){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));

        return mongoTemplate.findAndRemove(query, PlayerProfile.class);
    }
}
