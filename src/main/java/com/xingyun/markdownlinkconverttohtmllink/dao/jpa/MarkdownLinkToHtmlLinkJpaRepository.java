package com.xingyun.markdownlinkconverttohtmllink.dao.jpa;

import com.xingyun.markdownlinkconverttohtmllink.model.UrlDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author qing-feng.zhao
 */
public interface MarkdownLinkToHtmlLinkJpaRepository extends JpaRepository<UrlDataEntity,Long> {
}
