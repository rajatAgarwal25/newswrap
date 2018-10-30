package org.newswrap.pojo.response;

import java.io.Serializable;
import java.util.List;

public class NewsApiResponse implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private List<Article>     articles;

    private int               totalResults;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}
