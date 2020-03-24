package com.xingyun.markdownlinkconverttohtmllink.controller;

import com.xingyun.markdownlinkconverttohtmllink.dao.jpa.MarkdownLinkToHtmlLinkJpaRepository;
import com.xingyun.markdownlinkconverttohtmllink.model.UrlDataEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author qing-feng.zhao
 */
@Controller
public class HomePageController {

    private final MarkdownLinkToHtmlLinkJpaRepository markdownLinkToHtmlLinkJpaRepository;

    public HomePageController(MarkdownLinkToHtmlLinkJpaRepository markdownLinkToHtmlLinkJpaRepository) {
        this.markdownLinkToHtmlLinkJpaRepository = markdownLinkToHtmlLinkJpaRepository;
    }

    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }

    @GetMapping(value = "/url-added-page.do")
    public String urlAddedPage(){
        return "url-added-page";
    }

    @GetMapping(value = "/url-view-page.do")
    public String urlViewPage(Model model){
        List<UrlDataEntity> urlDataVOList=this.markdownLinkToHtmlLinkJpaRepository.findAll();
        model.addAttribute("urlDataList",urlDataVOList);
        return "url-view-page";
    }
}
