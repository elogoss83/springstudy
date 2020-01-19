package com.example.demo.dao;

import java.util.ArrayList;

import com.example.demo.controller.Article;

public class ArticleDao {

	ArrayList<Article> articles = new ArrayList<Article>();

	public ArrayList<Article> getArticles() {
		return this.articles;
	}

	public int lastId() {
		if (articles.size() < 1)
			return 0;
		else
			return articles.get(articles.size() - 1).getArticleId();
	}

	public void addArticle(String userId, String title, String body, String nick) {

		Article a = new Article();

		a.setArticleId(lastId() + 1);
		a.setUserId(userId);
		a.setTitle(title);
		a.setBody(body);
		a.setNick(nick);

		articles.add(a);
	}

	public String delArticle(int articleId) {
		for (int i = 0; i < this.articles.size(); i++) {
			if (articles.get(i).getArticleId() == articleId) {
				this.articles.remove(i);
				return String.valueOf(articleId + "번 글이 삭제되었습니다.");
			}
		}
		return String.valueOf(articleId + "번 글이 없습니다.");
	}

	public String upArticle(int articleId, String title, String body) {
		for (int i = 0; i < this.articles.size(); i++) {
			if (articles.get(i).getArticleId() == articleId) {
				articles.get(i).setTitle(title);
				articles.get(i).setBody(body);
				return String.valueOf(articleId + "번 글이 수정되었습니다.");
			}
		}
		return String.valueOf(articleId + "번 글이 없습니다.");
	}

}
