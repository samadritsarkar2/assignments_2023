package com.sam.helloworld.service;

import com.sam.helloworld.dto.request.UpdatePlayerProfileRequestDTO;
import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.repository.PlayerProfileRepository;
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




    public PlayerProfile create(PlayerProfile newPlayer)  {

        return playerProfileRepository.create(newPlayer);

    }

    public Collection<PlayerProfile> createBulk(List<PlayerProfile> playersList) {
        return playerProfileRepository.createBulk(playersList);
    }

    public PlayerProfile getPlayerProfileById(String playerId) {

        return playerProfileRepository.getPlayerProfileById(playerId);
    }

    public List<PlayerProfile> searchPlayerProfilesByName(String str) {
        List<PlayerProfile> listPlayerProfiles = playerProfileRepository.searchPlayerProfilesByName(str);
        return listPlayerProfiles;
    }

    public List<PlayerProfile> getAllPlayerProfiles() {
        return playerProfileRepository.getAllPlayerProfiles();
    }

    public PlayerProfile updatePlayerProfile(UpdatePlayerProfileRequestDTO updatePlayerProfileRequestDTO) {
        String playerId = updatePlayerProfileRequestDTO.getPlayerId();
        String field = updatePlayerProfileRequestDTO.getField();
        String newValue = updatePlayerProfileRequestDTO.getValue();
        return playerProfileRepository.updatePlayerProfile(playerId, field, newValue);
    }

    public PlayerProfile deletePlayerProfile(String playerId) {
        return playerProfileRepository.deletePlayerProfile(playerId);
    }

}
