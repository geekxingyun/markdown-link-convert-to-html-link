package com.xingyun.markdownlinkconverttohtmllink.model;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author qing-feng.zhao
 */
@Component
@Data
public class AppResponseVO {
    private Integer responseCode;
    private String responseMessage;
    private Object responseBusinessData;
}
