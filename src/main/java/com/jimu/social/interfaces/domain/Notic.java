package com.jimu.social.interfaces.domain;

import lombok.Data;

/**
 * 系统通知表
 * @table t_notic
 * @column unid 主键
 * @column title 标题
 * @column content 内容
 * @column link 链接
 * @column status 状态（0-正常 1-下架）
 * @column create_date 创建日期
 * @column modify_date 修改日期
 */
@Data
public class Notic {
    public String unid;
    public String title;
    public String content;
    public String link;
    public String status;
    public String createDate;
    public String modifyDate;
}
