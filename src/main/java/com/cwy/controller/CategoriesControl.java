package com.cwy.controller;

import com.cwy.service.ArticleService;
import com.cwy.service.CategoryService;
import com.cwy.utils.TransCodingUtil;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wayyee
 * @Date: 2020/7/17 20:50
 * Describe:
 */
@RestController
public class CategoriesControl {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ArticleService articleService;

    /**
     * 获得所有分类名以及每个分类名的文章数目
     * @return
     */
    @GetMapping("/findCategoriesNameAndArticleNum")
    public JSONObject findCategoriesNameAndArticleNum(){
        return categoryService.findCategoriesNameAndArticleNum();
    }

    /**
     * 分页获得该分类下的文章
     * @return
     */
    @GetMapping("/getCategoryArticle")
    public JSONObject getCategoryArticle(@RequestParam("category") String category,
                                         HttpServletRequest request){

        try {
            category = TransCodingUtil.unicodeToString(category);
        } catch (Exception e){
        }
        int rows = Integer.parseInt(request.getParameter("rows"));
        int pageNum = Integer.parseInt(request.getParameter("pageNum"));

        return articleService.findArticleByCategory(category, rows, pageNum);
    }


}
