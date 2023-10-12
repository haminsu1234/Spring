package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.controller.entity.ArticleEntity;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.service.ArticelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticelService service;
    @GetMapping("/article/list")
    public String list(Model model){

        List<ArticleEntity> articles = service.selectArticles();
        model.addAttribute("articles",articles);
        return "/article/list";
    }
    @GetMapping("/article/register")
    public String register(){
        return "/article/register";
    }

    @PostMapping("/article/register")
    public String register(HttpServletRequest request, ArticleDTO dto){

        dto.setRegip(request.getRemoteAddr());

        service.insertArticle(dto);
        return "redirect:/article/list";
    }

}
