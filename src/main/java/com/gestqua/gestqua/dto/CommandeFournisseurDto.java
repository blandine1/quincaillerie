package com.gestqua.gestqua.dto;


import com.gestqua.gestqua.entity.CommandeFournisseur;
import com.gestqua.gestqua.entity.Fournisseur;
import com.gestqua.gestqua.entity.LigneCommandeFournisseur;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CommandeFournisseurDto {
    private Integer id;
    private FournisseurDto fournisseurDto;
    private Double prix_total;
    private String description;
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    public static CommandeFournisseurDto  fromEntity(CommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null){
            return  null;
        }

        return  CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .fournisseurDto(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
                .prix_total(commandeFournisseur.getPrix_total())
                .description(commandeFournisseur.getDescription())
                .build();
    }

    public static CommandeFournisseur toEntiy(CommandeFournisseurDto commandeFournisseurDto){
        if(commandeFournisseurDto==null){
            return  null;
        }

        CommandeFournisseur fournisseur = new CommandeFournisseur();
        fournisseur.setId(commandeFournisseurDto.getId());
        fournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseurDto()));
        fournisseur.setPrix_total(commandeFournisseurDto.getPrix_total());
        fournisseur.setDescription(commandeFournisseurDto.getDescription());


        return fournisseur;
    }
}
