package com.gestqua.gestqua.dto;

import com.gestqua.gestqua.entity.Categorie;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategorieDto {
    private Integer id;
    private String name;
    private String description;
    private boolean status;

    public static CategorieDto fromEntity(Categorie categorie){
        if (categorie == null){
            return  null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .name(categorie.getName())
                .status(categorie.isStatus())
                .description(categorie.getDescription())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return  null;
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setName(categorieDto.getName());
        categorie.setStatus(categorieDto.isStatus());
        categorie.setDescription(categorieDto.getDescription());
        return categorie;
    }
}
