package com.jimu.social.interfaces.domain;

/**
 * @author liangqi
 * @date 2021/5/26 21:40
 */

import lombok.Data;

/**
    * 用户活动报名记录
    */
@Data
public class UserActiveRecord {
    /**
    * 主键，自增
    */
    private String unid;

    /**
    * 活动主键
    */
    private String activeId;

    /**
    * 用户主键
    */
    private String userId;

    /**
    * 状态（0-正常 1-删除）
    */
    private String status;

    /**
    * 创建日期
    */
    private String createDate;

    /**
    * 修改日期
    */
    private String modifyDate;
}
