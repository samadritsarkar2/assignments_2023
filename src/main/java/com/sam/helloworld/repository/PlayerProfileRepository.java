package com.sam.helloworld.repository;

import com.sam.helloworld.model.PlayerProfile;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerProfileRepository extends MongoRepository<PlayerProfile,Integer> {


    @DeleteQuery("{playerId : ?0}")
    public PlayerProfile deleteById2(int id);

//    @Query("{playerId : ?0}")
//    @Update("{$set : {'name' : ?1}}")
//    public void upsert(int playerId,String name);

    public List<PlayerProfile> findByName(String name);

}
