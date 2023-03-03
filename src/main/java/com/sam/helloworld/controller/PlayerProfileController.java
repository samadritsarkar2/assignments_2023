package com.sam.helloworld.controller;

import com.sam.helloworld.dto.request.ListPlayerProfileRequestDTO;
import com.sam.helloworld.dto.request.PlayerProfileRequestDTO;
import com.sam.helloworld.dto.response.ResponseDTO;
import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.service.PlayerProfileService;
import com.sam.helloworld.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;

    /**
     * Creates player and adds the profile to DB
     *
     * @param playerProfileRequestDTO accepts playerId Optional( name, totalRuns, totalWickets)
     * @return ResponseDTO
     */
    @PostMapping("/add")
    public ResponseDTO addPlayer(@RequestBody PlayerProfileRequestDTO playerProfileRequestDTO) {

        PlayerProfile playerProfile = Transformer.convertToPlayerProfile(playerProfileRequestDTO);
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>();

        try{
            PlayerProfile addedPlayer = playerProfileService.addPlayer(playerProfile);
            responseDTO.setSuccessObj();
            responseDTO.setData(addedPlayer);
        }catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
                responseDTO.setErrorObj();
                responseDTO.setErrMsg("Already Exists");
        }
        return responseDTO;
    }


    /**
     * Bulk create operation
     *
     * @param listPlayerProfileRequestDTO takes a JSON object that has list of PlayerProfile under "playerProfiles"
     * @return Response DTO
     */

    @PostMapping("/addMany")
    public ResponseDTO addManyPlayers(@RequestBody ListPlayerProfileRequestDTO listPlayerProfileRequestDTO) {

        List<PlayerProfile> playersList = Transformer.convertToListPlayerProfile(listPlayerProfileRequestDTO);

        Collection<PlayerProfile> listOfPlayers = playerProfileService.addPlayers(playersList);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(listOfPlayers);

        return responseDTO;
    }


    /**
     * Get a specific player and all of its details using playerId
     *
     * @param playerId Path variable
     * @return ResponseDTO's data field to have PlayerProfile Object
     */
    @GetMapping("/search/{playerId}")
    public ResponseDTO getPlayer(@PathVariable String playerId) {
        PlayerProfile searchedPlayer = playerProfileService.getPlayer(playerId);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(searchedPlayer);
        return responseDTO;
    }

    /**
     * Search for player(s) using name.
     *
     * @param name RequestParam
     * @return ResponseDTO. Returns a single or multiple Players with the same name.
     */

    @GetMapping("/search")
    public ResponseDTO<PlayerProfile> searchPlayers(@RequestParam String name) {
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false);

        List<PlayerProfile> listOfPlayers = playerProfileService.searchPlayers(name);
        responseDTO.setData(listOfPlayers);
        return responseDTO;
    }


    /**
     * Returns the list of all Players.
     *
     * @return ResponseDTO.data = List of PlayerProfiles
     */

    @GetMapping("/all")
    public ResponseDTO getAllPlayers() {
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false);

        List<PlayerProfile> allPlayers = playerProfileService.getAllPlayers();

        responseDTO.setData(allPlayers);

        return responseDTO;
    }


    /**
     * Update the name of the player using playerId
     *
     * @param playerId      RequestParam
     * @param newName RequestParam
     * @return ResponseDTO.data returns updated PlayerProfile
     */

    @PutMapping("/updateName")
    public ResponseDTO updatePlayerProfile(@RequestParam int playerId, @RequestParam String newName) {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        PlayerProfile updatedPlayer = playerProfileService.updatePlayerName(playerId, newName);
        responseDTO.setData(updatedPlayer);

        return responseDTO;

    }


    /**
     * Deletes the player with playerId
     *
     * @param playerId Request
     * @return ResponseDTO.data returns deleted PlayerProfile
     */

    @DeleteMapping("/delete")
    public ResponseDTO deletePlayer(@RequestParam int playerId) {

        PlayerProfile deletedPlayer = playerProfileService.deletePlayer(playerId);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        responseDTO.setData(deletedPlayer);
        return responseDTO;
    }

    /**
     * Increments field's value by value for all the players
     * @param field String
     * @param value int
     * @return
     */
    @PostMapping("/increment")
    public ResponseDTO increment(@RequestParam String field, @RequestParam int value){
            playerProfileService.increment(field,value);

          List<PlayerProfile> updatedResults =  playerProfileService.getAllPlayers();
          ResponseDTO responseDTO = new ResponseDTO<>();
          responseDTO.setSuccessObj();
          responseDTO.setData(updatedResults);
          return responseDTO;
    }



}
