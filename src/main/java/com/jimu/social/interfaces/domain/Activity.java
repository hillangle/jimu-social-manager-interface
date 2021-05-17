package com.jimu.social.interfaces.domain;

import lombok.Data;

/**
 * 活动表
 * @table t_activity
 * @column unid 主键
 * @column img 活动封面
 * @column name 活动名称
 * @column startTime 报名开始时间
 * @column endTime 报名结束时间
 * @column activeTime 活动开始时间
 * @column status 状态（0-正常 1-删除）
 * @column create_date 创建日期
 */
@Data
public class Activity {
    public String unid;
    public byte[] img;
    public String name;
    public String content;
    public String address;
    public String startTime;
    public String endTime;
    public String activeTime;
    public String status;
    public String createDate;
}
