package com.sam.helloworld.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePlayerProfileRequestDTO {


    private String playerId;
    private String field;

    private String value;

}
