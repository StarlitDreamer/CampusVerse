package com.ssm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

/**
 * @TableName category
 */
@TableName(value = "category")
@Data
public class Category implements Serializable {
    /**
     *
     */
    @NotNull(groups = Update.class)
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 分类名称
     */
    @NotEmpty/*(groups = {Add.class, Update.class})*/
    private String categoryName;

    /**
     * 分类别名
     */
    @NotEmpty/*(groups = {Add.class, Update.class})*/
    private String categoryAlias;

    /**
     *创建人ID
     */
    private Integer createUser;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     *
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    //如果说某个校验项没有指定分组,默认属于Default分组
    //分组之间可以继承, A extends B  那么A中拥有B中所有的校验项

    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}