package com.gestqua.gestqua.validator;

import com.gestqua.gestqua.dto.ArticleDto;
import com.gestqua.gestqua.dto.CategorieDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();

        if (articleDto == null) {
            errors.add("bien vouloir renseigner le nom de l'article");

            return  errors;
        }

        if (!StringUtils.hasLength(articleDto.getName())) {
            errors.add("bien vouloir renseigner le nom de l'article");
        }
        return errors;
    }
}
