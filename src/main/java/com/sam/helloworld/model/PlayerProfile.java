package com.sam.helloworld.model;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("playerProfile")
public class PlayerProfile {

    @Id
    private String  playerId;

    @NonNull
    @Indexed(unique = true)
    private String email;



    @Size(min = 3, max = 50, message = "Name must be withing 3 to 50 characters"
    )
//    @NotNull(message = "User's first name must not be null")
    private String name;

    private int totalRuns;

    private int totalWickets;

    public PlayerProfile() {
    }


}
