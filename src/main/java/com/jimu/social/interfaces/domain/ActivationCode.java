package com.jimu.social.interfaces.domain;

/**
 * @author liangqi
 * @date 2021/5/26 21:40
 */

import lombok.Data;

/**
    * 激活码表
    */
@Data
public class ActivationCode {
    /**
    * 主键，自增
    */
    private String unid;

    /**
    * 激活码
    */
    private String code;

    /**
    * 状态（0-未导出 1-未激活 2-已激活）
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
