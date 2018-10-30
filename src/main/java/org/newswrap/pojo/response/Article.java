package org.newswrap.pojo.response;

import java.io.Serializable;

public class Article implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String            title;

    private String            description;

    private String            url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
