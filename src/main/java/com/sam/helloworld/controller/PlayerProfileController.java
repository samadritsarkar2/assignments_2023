package com.sam.helloworld.controller;

import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;


    @PostMapping("/add")
    public PlayerProfile addPlayer(@RequestBody PlayerProfile playerProfile){
        PlayerProfile savedPlayer = playerProfileService.addPlayer(playerProfile);
        return savedPlayer;
    }

    @PostMapping("/addMany")
    public List<PlayerProfile> addManyPlayers(@RequestBody List<PlayerProfile> playersList){
        return playerProfileService.addPlayers(playersList);
    }

    @GetMapping("/search")
    public List<PlayerProfile> searchPlayers(@RequestParam String name){
        return playerProfileService.searchPlayers(name);
    }

    @GetMapping("/all")
    public List<PlayerProfile> getAllPlayers(){

        return playerProfileService.getAllPlayers();
    }

    @PostMapping("/updateName")
    public PlayerProfile updatePlayerProfile(@RequestParam int id, @RequestParam String newName){

        return playerProfileService.updatePlayerName(id, newName);

    }

    @PostMapping("/delete")
    public PlayerProfile deletePlayer(@RequestParam int id){
        return playerProfileService.deletePlayer(id);
    }

}
