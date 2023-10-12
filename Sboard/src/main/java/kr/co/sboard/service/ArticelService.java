package kr.co.sboard.service;

import kr.co.sboard.controller.entity.ArticleEntity;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticelService {

    @Autowired
    private ArticleRepository repo;

    public void insertArticle(ArticleDTO dto){
        ArticleEntity entity = dto.toEntity();
        repo.save(entity);
    }

    public List<ArticleEntity> selectArticles(){
        return repo.findAll();
    }



}
