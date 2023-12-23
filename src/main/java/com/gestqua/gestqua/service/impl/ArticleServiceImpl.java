package com.gestqua.gestqua.service.impl;

import com.gestqua.gestqua.Exceptions.EntityNotFoundException;
import com.gestqua.gestqua.Exceptions.ErrorCodes;
import com.gestqua.gestqua.Exceptions.InvalidEntityException;
import com.gestqua.gestqua.dto.ArticleDto;
import com.gestqua.gestqua.entity.Article;
import com.gestqua.gestqua.repository.ArticleRepository;
import com.gestqua.gestqua.service.ArticleService;
import com.gestqua.gestqua.validator.ArticleValidator;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors = ArticleValidator.validate(articleDto);

        if (!errors.isEmpty()){
            log.error("verrifier les carracteristiques de votre article");
            throw new InvalidEntityException("l'article n'est pas valid {}", ErrorCodes.ARTICLE_NOT_VALID);
        }

        Article article = articleRepository.findByName(articleDto.getName());

        if(article != null){
            log.error("l'article : "+ article.getName() + " existe deja");
           throw  new InvalidEntityException("Cet Article existe deja", ErrorCodes.ARTICLE_ALREADY_EXIST);
        }

        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
    }

    @Override
    public ArticleDto findbyId(Integer id) {

        if (id==null){
            log.error("le id est obligatoire");
            throw new InvalidEntityException("le id est obligatoire", ErrorCodes.ARTICLE_NOT_VALID);
        }

         Article byId = articleRepository.findById(id).get();

        if (byId.getId()==null){
            log.error("l'article avce cet Id : " +id +" n'exiate pas");
            throw new EntityNotFoundException("l'article avce cet Id :" +id +" n'exiate pas", ErrorCodes.ARTICLE_NOT_FOUND);
        }

        return ArticleDto.fromEntity(byId);
    }

    @Override
    public ArticleDto findByName(String name) {
        if (name.isEmpty()){
            log.error("le nom est obligatoire");
            throw new InvalidEntityException("le nom est obligatoire", ErrorCodes.ARTICLE_NOT_VALID);
        }

        Article byId = articleRepository.findByName(name);

        if (byId.getName().isEmpty()){
            log.error("l'article avce ce nom : " +name +" n'exiate pas");
            throw new EntityNotFoundException("l'article avce ce nom :" +name +" n'exiate pas", ErrorCodes.ARTICLE_NOT_FOUND);
        }

        return ArticleDto.fromEntity(byId);
    }

    @Override
    public void delete(Integer id) {
        if(id ==null){
            log.error("le id est obligatoire");
            throw new EntityNotFoundException("l'article avce cet Id :" +id +" n'exiate pas", ErrorCodes.ARTICLE_NOT_FOUND);
        }

        articleRepository.deleteById(id);

    }
    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }
}
