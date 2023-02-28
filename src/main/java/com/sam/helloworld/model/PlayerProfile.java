package com.sam.helloworld.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("playerProfiles")
public class PlayerProfile {

    @Id
    private int playerId;



    @Size(min = 3, max = 50, message = "Name must be withing 3 to 50 characters"
    )
//    @NotNull(message = "User's first name must not be null")
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
