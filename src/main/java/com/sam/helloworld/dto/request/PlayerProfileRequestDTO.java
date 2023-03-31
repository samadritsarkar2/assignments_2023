package com.sam.helloworld.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sam.helloworld.model.PlayerProfile;
import lombok.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class PlayerProfileRequestDTO {

    @NonNull
    private String email;

    @NonNull
    private String name;

    private int totalRuns;

    private int totalWickets;



}
