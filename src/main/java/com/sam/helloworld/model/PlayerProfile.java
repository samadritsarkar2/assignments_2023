package com.sam.helloworld.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("playerProfiles")
public class PlayerProfile {

    @Id
    private int playerId;
    private String name;

    private int totalRuns;

    private int totalWickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerProfile() {
    }

    public PlayerProfile(int playerId, String name){
        this.playerId = playerId;
        this.name = name;
        this.totalRuns = 0;
        this.totalWickets = 0;
    }


    public PlayerProfile(int playerId, String name, int totalRuns, int totalWickets){
        this.playerId = playerId;
        this.name = name;
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;
    }


}
