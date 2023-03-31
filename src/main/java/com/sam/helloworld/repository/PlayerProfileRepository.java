package com.sam.helloworld.repository;

import com.sam.helloworld.model.PlayerProfile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PlayerProfileRepository {

    public PlayerProfile create(PlayerProfile newPlayer) ;

    public Collection<PlayerProfile> createBulk(List<PlayerProfile> newPlayer);

    public PlayerProfile getPlayerProfileById(String playerId);
    public List<PlayerProfile> getAllPlayerProfiles();

    public List<PlayerProfile> searchPlayerProfilesByName(String str);

    public PlayerProfile updatePlayerProfile(String playerId, String field, String value);

    public PlayerProfile deletePlayerProfile(String playerId);

}
