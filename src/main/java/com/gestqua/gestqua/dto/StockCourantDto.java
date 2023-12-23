package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.StockCourant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockCourantDto {
    private  Integer id;
    private Double restant;
    private ArticleDto articleDto;


    //cette methode permet de convertir un objet (stockcourant) en DTO
    public static StockCourantDto fromtEntity(StockCourant stockCourant){
        if (stockCourant == null){
            return  null;
        }

        return StockCourantDto.builder()
                .id(stockCourant.getId())
                .restant(stockCourant.getRestant())
                .articleDto(ArticleDto.fromEntity(stockCourant.getArticle()))
                .build();
    }


    //cette function permet de convertir d'un DTO(en parametre) vers l'entite
    public static StockCourant toEntity(StockCourantDto stockCourantDto){
        if(stockCourantDto == null){
            return  null;
        }

        StockCourant stockCourant= new StockCourant();
        stockCourant.setId(stockCourantDto.getId());
        stockCourant.setRestant(stockCourantDto.getRestant());
        stockCourant.setArticle(ArticleDto.toEntity(stockCourantDto.getArticleDto()));

        return stockCourant;
    }
}
