package com.jimu.social.interfaces.domain;

import lombok.Data;

/**
 * 社交平台表
 * @table t_social
 * @column unid 主键
 * @column img 平台图标
 * @column name 平台名称
 * @column relation 平台关联关系（0-图片 1-链接）
 * @column status 状态（0-正常 1-删除）
 * @column create_date 创建日期
 */
@Data
public class Social {
    public String unid;
    public byte[] img;
    public String name;
    public String relation;
    public String status;
    public String createDate;
}
