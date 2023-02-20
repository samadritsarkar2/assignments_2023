package com.sam.helloworld.model;

import com.sam.helloworld.enums.InningStatus;

import java.util.List;


public class InningStats {
    private long inningId;
    private InningStatus inningStatus;
    private Team battingTeam;
    private Team bowlingTeam;

    private int totalRuns, extraRuns, wicket;

    List<DeliveryInfo> allDeliveries;

}
