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


    public PlayerProfile addPlayer(PlayerProfile newPlayer) throws MongoException {
        return mongoTemplate.insert(newPlayer);
    }

    public Collection<PlayerProfile> addPlayers(List<PlayerProfile> newPlayers){

       return mongoTemplate.insertAll(newPlayers);
    }

    public PlayerProfile getPlayer(int playerId){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));
        return mongoTemplate.findOne(query, PlayerProfile.class);
    }

    public List<PlayerProfile> getAllPlayers(){
        return mongoTemplate.findAll(PlayerProfile.class);
    }

    public List<PlayerProfile> searchPlayers(String str){
        Query query = new Query().addCriteria(Criteria.where("name").is(str));
        return mongoTemplate.find(query, PlayerProfile.class);
    }


    public PlayerProfile updatePlayerName(int playerId, String newName){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));
        Update updateName = new Update().set("name",newName);

        return mongoTemplate.findAndModify(query, updateName, new FindAndModifyOptions().returnNew(true),
                PlayerProfile.class);

    }

    public PlayerProfile deletePlayer(int playerId){
        Query query = new Query().addCriteria(Criteria.where("playerId").is(playerId));

        return mongoTemplate.findAndRemove(query, PlayerProfile.class);
    }

    public void test(){
        // Increment a particular field by value
//       Query emptyQuery = new Query();
//        Update update = new Update().inc(field, value);
//        mongoTemplate.updateMulti(emptyQuery, update, PlayerProfile.class);

        // Check for null values
//        Query query =
//                new Query().addCriteria(Criteria.where("totalRuns").isNull());
//
////        List<PlayerProfile> faultyProfiles = mongoTemplate.find(query, PlayerProfile.class);
//        System.out.println(mongoTemplate.find(query, PlayerProfile.class));

        //





    }
}
