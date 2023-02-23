package com.sam.helloworld.service;

import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.repository.CustomPlayerProfileRepository;
import com.sam.helloworld.repository.PlayerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlayerProfileService {

    @Autowired
    private PlayerProfileRepository playerProfileRepository;
    @Autowired
    private CustomPlayerProfileRepository customPlayerProfileRepository;


    public PlayerProfile addPlayer(PlayerProfile newPlayer){
        return playerProfileRepository.insert(newPlayer);

    }
    public List<PlayerProfile> addPlayers(List<PlayerProfile> playersList){
        return playerProfileRepository.saveAll(playersList);
    }
    public List<PlayerProfile> getAllPlayers(){
        return playerProfileRepository.findAll();
    }

    public List<PlayerProfile> searchPlayers(String str) {
        return playerProfileRepository.findByName(str);
    }
    public PlayerProfile updatePlayerName(int playerId, String newName) {
        return customPlayerProfileRepository.updatePlayerName(playerId,newName);
    }

    public PlayerProfile deletePlayer(int playerId){

//        PlayerProfile deletedPlayer = playerProfileRepository.findById(playerId).get();
        return playerProfileRepository.deleteById2(playerId);
    }

}
