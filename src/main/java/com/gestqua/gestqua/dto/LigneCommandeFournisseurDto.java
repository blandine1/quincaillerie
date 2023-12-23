package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {
    private Integer id;
    private ArticleDto articleDto;
    private Integer quantite;
    private Double prix_unitaire;
    private Double prix_total_partiel;
    private String description;
    private CommandeFournisseurDto commandeFournisseurDto;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur commandeFournisseur){
        if(commandeFournisseur == null){
            return  null;
        }

        return  LigneCommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .articleDto(ArticleDto.fromEntity(commandeFournisseur.getArticle()))
                .quantite(commandeFournisseur.getQuantite())
                .prix_total_partiel(commandeFournisseur.getPrix_total_partiel())
                .commandeFournisseurDto(CommandeFournisseurDto.fromEntity(commandeFournisseur.getCommandeFournisseur()))
                .description(commandeFournisseur.getDescription())
                .build();
    }

    public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto fournisseurDto){
        if(fournisseurDto == null){
            return  null;
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(ligneCommandeFournisseur.getId());
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(fournisseurDto.getArticleDto()));
        ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseur.getQuantite());
        ligneCommandeFournisseur.setPrix_total_partiel(ligneCommandeFournisseur.getPrix_total_partiel());
        ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntiy(fournisseurDto.getCommandeFournisseurDto()));
        ligneCommandeFournisseur.setDescription(ligneCommandeFournisseur.getDescription());

        return ligneCommandeFournisseur;
    }
}
