package com.cwy.service.impl;

import com.cwy.dao.mapper.CategoryMapper;
import com.cwy.service.ArticleService;
import com.cwy.service.CategoryService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wayyee
 * @Date: 2020/7/17 20:54
 * Describe:
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ArticleService articleService;

    @Override
    public JSONObject findCategoriesNameAndArticleNum() {
        List<String> categoryNames = categoryMapper.findCategoriesName();
        JSONObject categoryJson;
        JSONArray categoryJsonArray = new JSONArray();
        JSONObject returnJson = new JSONObject();
        for(String categoryName : categoryNames){
            categoryJson = new JSONObject();
            categoryJson.put("categoryName",categoryName);
            categoryJson.put("categoryArticleNum",articleService.countArticleCategoryByCategory(categoryName));
            categoryJsonArray.add(categoryJson);
        }
        returnJson.put("status",200);
        returnJson.put("result",categoryJsonArray);
        return returnJson;
    }

    @Override
    public JSONArray findCategoriesName() {
        List<String> categoryNames = categoryMapper.findCategoriesName();
        return JSONArray.fromObject(categoryNames);
    }

    @Override
    public int countCategoriesNum() {
        return categoryMapper.countCategoriesNum();
    }

}
