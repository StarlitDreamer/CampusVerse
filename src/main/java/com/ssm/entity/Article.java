package com.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.ssm.annotation.State;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @TableName article
 */
@TableName(value = "article")
@Data
public class Article implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @NotEmpty
    private String title;

    /**
     *
     */
    @NotEmpty
    private String content;

    /**
     * 文章封面
     */
    @NotEmpty
    @URL
    private String coverImg;

    /**
     * 发布状态 已发布|草稿
     */
    @State
    private String state;

    /**
     * 文章分类id
     */
    @NotNull
    private Integer categoryId;

    /**
     * 创建人ID
     */
    private Integer createUser;

    /**
     *
     */
    private LocalDateTime createTime;

    /**
     *
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}