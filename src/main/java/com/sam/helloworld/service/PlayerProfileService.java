package com.sam.helloworld.service;

import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.repository.PlayerProfileRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
public class PlayerProfileService {


    @Autowired
    private PlayerProfileRepositoryImpl playerProfileRepository;


    public PlayerProfile addPlayer(PlayerProfile newPlayer){
        return playerProfileRepository.addPlayer(newPlayer);

    }
    public Collection<PlayerProfile> addPlayers(List<PlayerProfile> playersList){
        return playerProfileRepository.addPlayers(playersList);
    }

    public PlayerProfile getPlayer(int playerId){
        return playerProfileRepository.getPlayer(playerId);
    }

    public List<PlayerProfile> getAllPlayers(){
        return playerProfileRepository.getAllPlayers();
    }

    public List<PlayerProfile> searchPlayers(String str) {
        return playerProfileRepository.searchPlayers(str);
    }
    public PlayerProfile updatePlayerName(int playerId, String newName) {
        return playerProfileRepository.updatePlayerName(playerId,newName);
    }

    public PlayerProfile deletePlayer(int playerId){
        return playerProfileRepository.deletePlayer(playerId);
    }

}
