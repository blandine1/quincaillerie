package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.Client;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
@Data
@Builder
public class ClientDto {
    private Integer id;
    private String name;
    private String prenom;
    private String phone;
    private boolean status;
    private String description;
    private Date createdDate;
    private Date updatedDate;

    public static ClientDto fromEntity(Client client){
        if (client == null){
            return  null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .prenom(client.getPrenom())
                .phone(client.getPhone())
                .status(client.isStatus())
                .description(client.getDescription())
                .build();
    }

    public static Client toEntity(ClientDto clientDto){
        if(clientDto == null){
            return  null;
        }

        Client client = new Client();
        client.setId(clientDto.getId());
        client.setName(clientDto.getName());
        client.setPhone(clientDto.getPhone());
        client.setStatus(clientDto.isStatus());
        client.setDescription(clientDto.getDescription());
        return client;
    }
}
