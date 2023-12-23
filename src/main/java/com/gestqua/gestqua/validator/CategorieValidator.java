package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategorieValidator {
   public static List<String> validate(CategorieDto categorieDto){
       List<String> errors = new ArrayList<>();

       if(categorieDto==null){
           errors.add("bien vouloir renseigner le nom de la categorie");

           return errors;
       }

       if(!StringUtils.hasLength(categorieDto.getName())){
          errors.add("bien vouloir renseigner le nom de la categorie");
       }
       return errors;
   }

}
