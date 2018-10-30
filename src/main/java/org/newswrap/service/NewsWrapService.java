package org.newswrap.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.newswrap.helperservices.NewsApiHelper;
import org.newswrap.pojo.response.Article;
import org.newswrap.pojo.response.NewsApiResponse;
import org.newswrap.pojo.response.NewsWrapped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsWrapService {

    @Autowired
    private NewsApiHelper newsApiHelper;

    public NewsWrapped getNewsContent(String country, String category, String keyword) {
        NewsApiResponse newsApiResponse = newsApiHelper.getNewsContent(country, category);
        List<Article> relevantArticles = new ArrayList<>();
        NewsWrapped nw = new NewsWrapped();
        nw.setCategory(category);
        nw.setCountry(country);
        nw.setFilterKeyword(keyword);
        if (keyword != null) {
            for (Article article : newsApiResponse.getArticles()) {

                String[] titleWords = article.getTitle().split(" ");
                if (Arrays.asList(titleWords).stream().map(e -> e.toLowerCase()).collect(Collectors.toSet())
                        .contains(keyword.toLowerCase())) {
                    relevantArticles.add(article);
                }
                else if (article.getDescription() != null) {
                    String[] words = article.getDescription().split(" ");
                    if (Arrays.asList(words).stream().map(e -> e.toLowerCase()).collect(Collectors.toSet())
                            .contains(keyword.toLowerCase())) {
                        relevantArticles.add(article);
                    }
                }
            }
            nw.setArticles(relevantArticles);
        }
        else {
            nw.setArticles(newsApiResponse.getArticles());
        }
        return nw;
    }
}
