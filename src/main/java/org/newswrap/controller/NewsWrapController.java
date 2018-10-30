package org.newswrap.controller;

import org.newswrap.pojo.response.GenericApiResponse;
import org.newswrap.service.NewsWrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/v1/")
public class NewsWrapController {

    @Autowired
    private NewsWrapService newsWrapService;

    @RequestMapping(value = "/top-headlines", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(notes = "Wrapper api on newsapi", value = "Wrapper api on newsapi")
    public GenericApiResponse getWrappedNews(
            @RequestParam String country,
            @RequestParam String category,
            @RequestParam(required = false) String keyword) {
        return new GenericApiResponse(newsWrapService.getNewsContent(country, category, keyword));
    }

}
