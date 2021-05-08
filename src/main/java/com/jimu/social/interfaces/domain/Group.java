package com.jimu.social.interfaces.domain;

import lombok.Data;

/**
 * 兴趣小组表
 * @table t_group
 * @column unid 主键
 * @column name 兴趣小组名称
 * @column status 状态（0-正常 1-删除）
 * @column create_date 创建日期
 */
@Data
public class Group {
    public String unid;
    public String name;
    public String status;
    public String createDate;
}
