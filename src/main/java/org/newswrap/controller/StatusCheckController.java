package org.newswrap.controller;

import org.newswrap.pojo.response.GenericApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/ping")
public class StatusCheckController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(notes = "API for status check", value = "API to check tomcat status")
    public GenericApiResponse ping() {
        return new GenericApiResponse("pong");
    }
}
