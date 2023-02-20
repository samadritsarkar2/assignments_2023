package com.sam.helloworld.model;


import lombok.Data;

@Data
public class PlayerProfile {

    private long playerId;
    private String name;

    private int totalRuns;

    private int totalWickets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
