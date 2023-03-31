package com.sam.helloworld.controller;

import com.sam.helloworld.dto.request.ListPlayerProfileRequestDTO;
import com.sam.helloworld.dto.request.PlayerProfileRequestDTO;
import com.sam.helloworld.dto.request.UpdatePlayerProfileRequestDTO;
import com.sam.helloworld.dto.response.ResponseDTO;
import com.sam.helloworld.model.PlayerProfile;
import com.sam.helloworld.service.PlayerProfileService;
import com.sam.helloworld.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/player-profile")
public class PlayerProfileController {

    @Autowired
    PlayerProfileService playerProfileService;

    /**
     * Creates player and adds the profile to DB
     *
     * @param playerProfileRequestDTO accepts name, email and Optional( totalRuns, totalWickets)
     * @return ResponseDTO
     */
    @PostMapping("/create")
    public ResponseDTO create(@RequestBody PlayerProfileRequestDTO playerProfileRequestDTO) {

        PlayerProfile playerProfile = Transformer.convertToPlayerProfile(playerProfileRequestDTO);
//        System.out.println(playerProfile);
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>();

        try{
            PlayerProfile createdPlayerProfile = playerProfileService.create(playerProfile);
            responseDTO.setSuccessObj();
            responseDTO.setData(createdPlayerProfile);
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

    @PostMapping("/create/bulk")
    public ResponseDTO createBulk(@RequestBody ListPlayerProfileRequestDTO listPlayerProfileRequestDTO) {

        List<PlayerProfile> playersList = Transformer.convertToListPlayerProfile(listPlayerProfileRequestDTO);

        Collection<PlayerProfile> listCreatedPlayerProfiles = playerProfileService.createBulk(playersList);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(listCreatedPlayerProfiles);

        return responseDTO;

    }


    /**
     * Get a specific player and all of its details using playerId
     *
     * @param playerId Path variable
     * @return ResponseDTO's data field to have PlayerProfile Object
     */
    @GetMapping("/search/id/{playerId}")
    public ResponseDTO getPlayer(@PathVariable String playerId) {
        PlayerProfile searchedPlayerProfile = playerProfileService.getPlayerProfileById(playerId);

        ResponseDTO responseDTO = new ResponseDTO<>();
        responseDTO.setSuccessObj();
        responseDTO.setData(searchedPlayerProfile);
        return responseDTO;
    }

    /**
     * Search for player(s) using name.
     *
     * @param playerName Path Variable
     * @return ResponseDTO. Returns a single or multiple Players with the same name.
     */

    @GetMapping("/search/name/{playerName}")
    public ResponseDTO<PlayerProfile> searchPlayers(@PathVariable String playerName) {
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false);

        List<PlayerProfile> listPlayerProfiles = playerProfileService.searchPlayerProfilesByName(playerName);
        responseDTO.setData(listPlayerProfiles);
        return responseDTO;
    }


    /**
     * Returns the list of all Players.
     *
     * @return ResponseDTO.data = List of PlayerProfiles
     */

    @GetMapping("/all")
    public ResponseDTO getAllPlayerProfiles() {
        ResponseDTO responseDTO = new ResponseDTO<PlayerProfile>(true, 200, false);

        List<PlayerProfile> allPlayerProfiles = playerProfileService.getAllPlayerProfiles();

        responseDTO.setData(allPlayerProfiles);

        return responseDTO;
    }


    /**
     * Update the name of the player using playerId
     *
     * @param  updatePlayerProfileRequestDTO - RequestBody - accepts playerId, field, value
     * @return ResponseDTO.data returns updated PlayerProfile
     */

    @PutMapping("/update")
    public ResponseDTO updatePlayerProfile(@RequestBody UpdatePlayerProfileRequestDTO updatePlayerProfileRequestDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        PlayerProfile updatedPlayerProfile = playerProfileService.updatePlayerProfile(updatePlayerProfileRequestDTO);
        responseDTO.setData(updatedPlayerProfile);

        return responseDTO;

    }


    /**
     * Deletes the player with playerId
     *
     * @param playerId Request
     * @return ResponseDTO.data returns deleted PlayerProfile
     */

    @DeleteMapping("/delete/{playerId}")
    public ResponseDTO deletePlayer(@PathVariable String playerId) {

        PlayerProfile deletedPlayer = playerProfileService.deletePlayerProfile(playerId);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setSuccessObj();
        responseDTO.setData(deletedPlayer);
        return responseDTO;
    }

}
