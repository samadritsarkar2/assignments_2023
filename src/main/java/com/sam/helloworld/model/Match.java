package com.sam.helloworld.model;

import com.sam.helloworld.enums.Country;
import com.sam.helloworld.enums.MatchStatus;
import com.sam.helloworld.enums.MatchType;

import java.util.List;

public class Match {
    private long matchId;

    private MatchType matchType;
    private MatchStatus matchStatus;
    private Country country1;
    private Country country2;

    // Should we use team Obj or teamID?
    private Team team1;
    private Team team2;





    List<Long> listOfInnings;


}
