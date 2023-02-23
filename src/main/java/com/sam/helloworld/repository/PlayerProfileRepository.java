package com.sam.helloworld.repository;

import com.sam.helloworld.model.PlayerProfile;

import java.util.Collection;
import java.util.List;

public interface PlayerProfileRepository {

    public PlayerProfile addPlayer(PlayerProfile newPlayer);

    public Collection<PlayerProfile> addPlayers(List<PlayerProfile> newPlayer);

    public List<PlayerProfile> getAllPlayers();

    public List<PlayerProfile> searchPlayers(String str);

    public PlayerProfile updatePlayerName(int playerId, String newName);

    public PlayerProfile deletePlayer(int playerId);

}
