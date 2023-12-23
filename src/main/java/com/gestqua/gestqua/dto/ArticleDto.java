package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.Article;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
    private Integer id;
    private String name;
    private boolean status;
    private String description;

    public static ArticleDto fromEntity(Article article){
        if (article == null){
            return  null;
        }

        return ArticleDto.builder()
                .id(article.getId())
                .name(article.getName())
                .status(article.isStatus())
                .description(article.getDescription())
                .build();
    }

    public static Article toEntity(ArticleDto articleDto){
        if(articleDto == null){
            return  null;
        }

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setStatus(articleDto.isStatus());
        article.setDescription(articleDto.getDescription());
        return article;
    }
}
