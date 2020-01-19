package com.example.demo.controller; 

import java.util.ArrayList;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dao.ArticleDao;

@Controller
public class ArticleController {

	ArticleDao dao = new ArticleDao();

	@RequestMapping("articleList")
	@ResponseBody
	public ArrayList<Article> articlelist() {

		return dao.getArticles();
	}

	@RequestMapping("addArticle")
	@ResponseBody
	public String add(String userId, String title, String body, String nick) {
		dao.addArticle(userId, title, body, nick);
		return "게시물이 저장되었습니다.";
	}

	@RequestMapping("delArticle")
	@ResponseBody
	public String del(int articleId) {
		return dao.delArticle(articleId);
	}

	@RequestMapping("upArticle")
	@ResponseBody
	public String up(int articleId, String title, String body) {
		return dao.upArticle(articleId, title, body);
	}

}
