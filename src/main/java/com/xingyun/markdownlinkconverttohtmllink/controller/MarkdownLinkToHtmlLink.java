package com.xingyun.markdownlinkconverttohtmllink.controller;

import com.xingyun.markdownlinkconverttohtmllink.dao.jpa.MarkdownLinkToHtmlLinkJpaRepository;
import com.xingyun.markdownlinkconverttohtmllink.model.AppResponseVO;
import com.xingyun.markdownlinkconverttohtmllink.model.UrlDataEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author qing-feng.zhao
 */
@Slf4j
@RequestMapping(value = "/api/v1")
@RestController
public class MarkdownLinkToHtmlLink {

    private final AppResponseVO appResponseVO;

    private final MarkdownLinkToHtmlLinkJpaRepository markdownLinkToHtmlLinkJpaRepository;
    public MarkdownLinkToHtmlLink(AppResponseVO appResponseVO,MarkdownLinkToHtmlLinkJpaRepository markdownLinkToHtmlLinkJpaRepository) {
        this.appResponseVO = appResponseVO;
        this.markdownLinkToHtmlLinkJpaRepository=markdownLinkToHtmlLinkJpaRepository;
    }

    @PostMapping(value = "/url-added-api.do")
    public AppResponseVO saveUrl(@RequestParam("link")String link,@RequestParam("label")String label){
        log.info("要添加的链接URL为:{}",link);
        log.info("要添加的链接标签为:{}",label);
        if(null==link||null==label){
            log.error("link or label can't be null");
            appResponseVO.setResponseCode(401);
            appResponseVO.setResponseMessage("added fail,link and label can't be null");
            appResponseVO.setResponseBusinessData(null);
            return appResponseVO;
        }else{
            UrlDataEntity urlDataEntity=new UrlDataEntity();
            urlDataEntity.setLink(link);
            urlDataEntity.setLabel(label);
            urlDataEntity.setAlign("left");
            urlDataEntity.setTarget("_blank");
            Example<UrlDataEntity> urlDataEntityExample=Example.of(urlDataEntity);
            Optional<UrlDataEntity> urlDataEntityOptional=markdownLinkToHtmlLinkJpaRepository.findOne(urlDataEntityExample);
            if(urlDataEntityOptional.isPresent()){
                log.info("已经添加过");
                appResponseVO.setResponseCode(500);
                appResponseVO.setResponseMessage("added fail!,you had added it");
                appResponseVO.setResponseBusinessData(null);
            }else{
                markdownLinkToHtmlLinkJpaRepository.save(urlDataEntity);
                appResponseVO.setResponseCode(200);
                appResponseVO.setResponseMessage("added success!");
                appResponseVO.setResponseBusinessData(urlDataEntity);
            }
        }
        return appResponseVO;
    }
}
