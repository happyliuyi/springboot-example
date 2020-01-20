package com.example.swagger.com.example.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@RestController
@RequestMapping("/art")
@Api(tags = "文章控制器")
public class ArticleController {

    @ApiOperation(value = "获取所有文章", notes = "查询分页数据")
    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    public String getAll() {
        return "所有文章";
    }


    @ApiOperation(value = "获取单篇文章", notes = "获取单篇文章")
    @RequestMapping(value = "/getone/{title}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "title", value = "文章名", required = true, paramType = "path") //http://localhost:8080/art/getone/{title}
    public String getOne(String title) {
        return "单篇";
    }

    
    @ApiOperation(value = "查询文章作者名", notes = "获取文章篇文章")
    @RequestMapping(value = "/getAuthor", method = RequestMethod.POST)
    @ApiImplicitParam(name = "title", value = "文章名", required = true, paramType = "form")
    public String getAuthor(String title) {
        return "Tracy";
    }
    
    @ApiOperation(value = "查询某个作者的文章", notes = "获取文章篇文章")
    @RequestMapping(value = "/getAuthorBooks", method = RequestMethod.GET)
    @ApiImplicitParam(name = "AuthorName", value = "文章名", required = true, paramType = "query")  //即query 是查询路径带？的 eg:http://localhost:8080/art/getAuthorBooks?AuthorName=lucy
    public String getAuthorBooks(String AuthorName) {
        return "Tracy' life";
    }

}
