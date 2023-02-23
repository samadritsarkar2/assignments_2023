package com.sam.helloworld.controller;

import com.sam.helloworld.dto.ResponseDTO;
import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.service.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;


    @PostMapping("/add")
    public ResponseDTO addPlayer(@RequestBody PlayerProfile playerProfile){

        PlayerProfile addedPlayer = playerProfileService.addPlayer(playerProfile);
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false,"", addedPlayer );
        return responseDTO;
    }

    @PostMapping("/addMany")
    public ResponseDTO addManyPlayers(@RequestBody List<PlayerProfile> playersList){

        Collection<PlayerProfile> listOfPlayers = playerProfileService.addPlayers(playersList);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(listOfPlayers);

        return responseDTO;
    }

    @GetMapping("/search/{playerId}")
    public ResponseDTO getPlayer(@PathVariable int playerId){
        PlayerProfile searchedPlayer = playerProfileService.getPlayer(playerId);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(searchedPlayer);
        return responseDTO;
    }

    @GetMapping("/search")
    public ResponseDTO<PlayerProfile> searchPlayers(@RequestParam String name){
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false );

        List<PlayerProfile> listOfPlayers = playerProfileService.searchPlayers(name);
        responseDTO.setData(listOfPlayers);
        return responseDTO;
    }

    @GetMapping("/all")
    public ResponseDTO getAllPlayers(){
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false );

        List<PlayerProfile> allPlayers = playerProfileService.getAllPlayers();

        responseDTO.setData(allPlayers);

        return responseDTO;
    }

    @PutMapping("/updateName")
    public ResponseDTO updatePlayerProfile(@RequestParam int id, @RequestParam String newName){

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        PlayerProfile updatedPlayer = playerProfileService.updatePlayerName(id, newName);
        responseDTO.setData(updatedPlayer);

        return responseDTO;

    }

    @DeleteMapping("/delete")
    public ResponseDTO deletePlayer(@RequestParam int id){

        PlayerProfile deletedPlayer = playerProfileService.deletePlayer(id);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        responseDTO.setData(deletedPlayer);
        return responseDTO;
    }

}
