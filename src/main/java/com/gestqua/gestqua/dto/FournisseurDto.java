package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.Fournisseur;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;

@Data
@Builder
public class FournisseurDto {
    private Integer id;
    private String name;
    private String prenom;
    private String phone;
    private boolean status;
    private String description;
    private Timestamp creationDate;
    private Timestamp lastUpdatedDate;

    //il prend un fournisseur puis il retourne son dto
    public static FournisseurDto fromEntity(Fournisseur fournisseur){
        if (fournisseur==null){
         return null;
        }

        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .name(fournisseur.getName())
                .prenom(fournisseur.getPrenom())
                .phone(fournisseur.getPhone())
                .status(fournisseur.isStatus())
                .description(fournisseur.getDescription())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto){
        if(fournisseurDto==null){
            return null;
        }

        Fournisseur fournisseur= new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setName(fournisseurDto.getName());
        fournisseur.setPrenom(fournisseurDto.getPrenom());
        fournisseur.setPhone(fournisseurDto.getPhone());
        fournisseur.setStatus(fournisseurDto.isStatus());
        fournisseur.setDescription(fournisseurDto.getDescription());

        return fournisseur;
    }
}
