package com.jimu.social.interfaces.domain.vo;


import lombok.Data;

/**
    * 激活码表
    */
@Data
public class ActivationCodeVO {

    /**
     * 创建日期
     */
    private String createDate;
    
    /**
    * 未导出
    */
    private String status0;

    /**
    * 未激活
    */
    private String status1;

    /**
    * 已激活
    */
    private String status2;
}
