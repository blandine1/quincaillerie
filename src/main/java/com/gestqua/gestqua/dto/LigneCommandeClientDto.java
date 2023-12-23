package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.LigneCommndeClient;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {
    private Integer id;
    private ArticleDto articleDto;
    private Integer quantite;
    private Double prix_unitaire;
    private Double prix_total_partiel;
    private String description;
    private CommandeClientDto commandeClientDto;

    public static LigneCommandeClientDto fromEntity(LigneCommndeClient ligneCommndeClient){
        if(ligneCommndeClient == null){
            return  null;
        }

        return  LigneCommandeClientDto.builder()
                .id(ligneCommndeClient.getId())
                .articleDto(ArticleDto.fromEntity(ligneCommndeClient.getArticle()))
                .quantite(ligneCommndeClient.getQuantite())
                .prix_total_partiel(ligneCommndeClient.getPrix_total_partiel())
                .commandeClientDto(CommandeClientDto.fromEtity(ligneCommndeClient.getCommandeClient()))
                .description(ligneCommndeClient.getDescription())
                .build();
    }

    public static LigneCommndeClient toEntity(LigneCommandeClientDto commandeClientDto){
        if(commandeClientDto == null){
            return  null;
        }

        LigneCommndeClient ligneCommndeClient = new LigneCommndeClient();
        ligneCommndeClient.setId(commandeClientDto.getId());
        ligneCommndeClient.setArticle(ArticleDto.toEntity(commandeClientDto.getArticleDto()));
        ligneCommndeClient.setQuantite(ligneCommndeClient.getQuantite());
        ligneCommndeClient.setPrix_total_partiel(commandeClientDto.getPrix_total_partiel());
        ligneCommndeClient.setCommandeClient(CommandeClientDto.toEntity(commandeClientDto.getCommandeClientDto()));
        ligneCommndeClient.setDescription(commandeClientDto.getDescription());

        return ligneCommndeClient;
    }
}
