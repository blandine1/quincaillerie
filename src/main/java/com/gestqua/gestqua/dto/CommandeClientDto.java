package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.CommandeClient;
import com.gestqua.gestqua.entity.LigneCommndeClient;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommandeClientDto {
    private Integer id;
    private ClientDto clientDto;
    private Double prix_total;
    private List<LigneCommndeClient> ligneCommndeClients;
    private String description;

    public static  CommandeClientDto fromEtity(CommandeClient commandeClient){
        if(commandeClient == null){
            return  null;
        }

        return  CommandeClientDto.builder()
                .id(commandeClient.getId())
                .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
                .prix_total(commandeClient.getPrix_total())
                .description(commandeClient.getDescription())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
        if(commandeClientDto ==  null){
            return  null;
        }

        CommandeClient commandeClient = new CommandeClient();
        commandeClient.setId(commandeClientDto.getId());
        commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClientDto()));
        commandeClient.setPrix_total(commandeClientDto.getPrix_total());
        commandeClient.setDescription(commandeClientDto.getDescription());

        return commandeClient;
    }
}
