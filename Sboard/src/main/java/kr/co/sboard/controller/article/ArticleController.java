package kr.co.sboard.controller.article;

import jakarta.servlet.http.HttpServletRequest;
import kr.co.sboard.controller.entity.ArticleEntity;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.service.ArticelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

    @Autowired
    private ArticelService service;
    @GetMapping("/article/list")
    public String list(/*@PathVariable("cate") */String cate, @RequestParam(defaultValue = "1") int pg, Model model ){


        String useyn="Y";

        Page<ArticleEntity> articles = service.selectArticles2(useyn,0,pg,cate);
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
