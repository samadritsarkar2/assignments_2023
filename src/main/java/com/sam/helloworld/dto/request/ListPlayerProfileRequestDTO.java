package com.sam.helloworld.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListPlayerProfileRequestDTO {

    List<PlayerProfileRequestDTO> playerProfiles;
}
