package com.sam.helloworld.controller.model;


import lombok.Data;

@Data
public class PlayerProfile {

    private int id;
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
