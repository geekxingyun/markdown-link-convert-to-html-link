package com.xingyun.markdownlinkconverttohtmllink.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author qing-feng.zhao
 */
@Data
@Entity
public class UrlDataEntity {
    /**
     *
     */
    @Id
    @GeneratedValue(generator = "SnowFlakeId")
    @GenericGenerator(name = "SnowFlakeId", strategy ="com.xingyun.markdownlinkconverttohtmllink.customize.SnowFlakeIdGenerator")
    @Column(name = "pk_uuid")
    private Long pkId;
    @Column(name = "label")
    private String label;
    @Column(name = "link")
    private String link;
    @Column(name = "align")
    private String align;
    @Column(name = "target")
    private String target;
}
