package com.sam.helloworld.repository;

import com.sam.helloworld.model.PlayerProfile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PlayerProfileRepository {

    public PlayerProfile addPlayer(PlayerProfile newPlayer);

    public Collection<PlayerProfile> addPlayers(List<PlayerProfile> newPlayer);

    public PlayerProfile getPlayer(int playerId);
    public List<PlayerProfile> getAllPlayers();

    public List<PlayerProfile> searchPlayers(String str);

    public PlayerProfile updatePlayerName(int playerId, String newName);

    public PlayerProfile deletePlayer(int playerId);

}
