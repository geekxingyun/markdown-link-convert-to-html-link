package com.xingyun.markdownlinkconverttohtmllink.model;

import lombok.Data;

/**
 * @author qing-feng.zhao
 */
@Data
public class UrlDataVO {
    private Long pkId;
    private String label;
    private String link;
    private String align;
    private String target;
}
