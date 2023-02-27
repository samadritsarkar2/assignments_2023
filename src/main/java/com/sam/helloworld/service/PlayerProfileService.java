package com.sam.helloworld.service;

import com.sam.helloworld.dto.request.PlayerProfileRequestDTO;
import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.repository.PlayerProfileRepository;
import com.sam.helloworld.repository.PlayerProfileRepositoryImpl;
import com.sam.helloworld.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


@Service
@ConfigurationProperties(prefix = "player.name")
public class PlayerProfileService {


    @Autowired
    private PlayerProfileRepository playerProfileRepository;

    private String userName;


    public PlayerProfile addPlayer(PlayerProfile newPlayer)  {

        System.out.println(userName);

        return playerProfileRepository.addPlayer(newPlayer);

    }

    public Collection<PlayerProfile> addPlayers(List<PlayerProfile> playersList) {
        return playerProfileRepository.addPlayers(playersList);
    }

    public PlayerProfile getPlayer(int playerId) {

        return playerProfileRepository.getPlayer(playerId);
    }

    public List<PlayerProfile> searchPlayers(String str) {
        List<PlayerProfile> listOfPlayers = playerProfileRepository.searchPlayers(str);
        return listOfPlayers;
    }

    public List<PlayerProfile> getAllPlayers() {
        return playerProfileRepository.getAllPlayers();
    }

    public PlayerProfile updatePlayerName(int playerId, String newName) {
        return playerProfileRepository.updatePlayerName(playerId, newName);
    }

    public PlayerProfile deletePlayer(int playerId) {
        return playerProfileRepository.deletePlayer(playerId);
    }

}
