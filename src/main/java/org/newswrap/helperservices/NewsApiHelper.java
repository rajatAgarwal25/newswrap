package org.newswrap.helperservices;

import org.newswrap.constant.Constant;
import org.newswrap.pojo.response.NewsApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NewsApiHelper {

    @Value("${newsapi.endpoint}")
    private String NEWSAPI_ENDPOINT;

    @Value("${newsapi.apikey}")
    private String NEWSAPI_APIKEY;

    public NewsApiResponse getNewsContent(String country, String category) {
        StringBuilder uri = new StringBuilder(NEWSAPI_ENDPOINT).append(Constant.QUESTION_MARK)
                .append(Constant.COUNTRY + Constant.EQUAL_TO).append(country).append(Constant.AMPERSAND)
                .append(Constant.API_KEY + Constant.EQUAL_TO).append(NEWSAPI_APIKEY);
        if (category != null && !category.isEmpty()) {
            uri.append(Constant.AMPERSAND).append(Constant.CATEGORY + Constant.EQUAL_TO).append(category);
        }
        String url = uri.toString();

        RestTemplate restTemplate = new RestTemplate();
        NewsApiResponse newsApiResponse = restTemplate.getForObject(url, NewsApiResponse.class);
        return newsApiResponse;
    }

}
