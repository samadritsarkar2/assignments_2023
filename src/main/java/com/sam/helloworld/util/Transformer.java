package com.sam.helloworld.util;

import com.sam.helloworld.dto.request.PlayerProfileRequestDTO;
import com.sam.helloworld.model.PlayerProfile;


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
}
