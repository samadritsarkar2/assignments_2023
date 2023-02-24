package com.sam.helloworld.util;

import com.sam.helloworld.dto.request.ListPlayerProfileRequestDTO;
import com.sam.helloworld.dto.request.PlayerProfileRequestDTO;
import com.sam.helloworld.model.PlayerProfile;

import java.util.ArrayList;
import java.util.List;


public class Transformer {


    // Converts PlayerProfileRequestDTO to PlayerProfile Object;
    public static PlayerProfile convertToPlayerProfile(PlayerProfileRequestDTO playerProfileRequestDTO){
        PlayerProfile createdPlayerProfile = new PlayerProfile();

        createdPlayerProfile.setPlayerId(playerProfileRequestDTO.getPlayerId());

        if(playerProfileRequestDTO.getName() != null)
            createdPlayerProfile.setName(playerProfileRequestDTO.getName());

        if(playerProfileRequestDTO.getTotalRuns() != 0)
            createdPlayerProfile.setTotalRuns(playerProfileRequestDTO.getTotalRuns());

        if(playerProfileRequestDTO.getTotalWickets() != 0){
            createdPlayerProfile.setTotalWickets(playerProfileRequestDTO.getTotalWickets());
        }

        return createdPlayerProfile;
    }

    public static List<PlayerProfile> convertToListPlayerProfile(ListPlayerProfileRequestDTO listPlayerProfileRequestDTO){
        List<PlayerProfile> playerProfileList = new ArrayList<>();
        List<PlayerProfileRequestDTO> playerProfileRequestDTOS = listPlayerProfileRequestDTO.getPlayerProfiles();

        for (PlayerProfileRequestDTO playerProfileRequestDTO : playerProfileRequestDTOS )
        {
            playerProfileList.add(Transformer.convertToPlayerProfile(playerProfileRequestDTO));
        }
        return playerProfileList;
    }

}
