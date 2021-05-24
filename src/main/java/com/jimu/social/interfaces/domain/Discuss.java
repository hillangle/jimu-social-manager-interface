package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 评论表
 * @table t_discuss
 * @column unid 主键
 * @column userId 用户主键
 * @column activityId 兴趣小组主键
 * @column content 内容
 * @column status 状态(0-正常 1-隐藏)
 * @column createDate 发布时间
 */
@Data
public class Discuss {
    public String unid;
    public String userId;
    public String tendencyId;
    public String content;
    public String status;
    public String createDate;

    public SysUser user;

    public Tendency tendency;

    @Override
    public String toString() {
        return "Tendency{ unid=" + unid +
                ", user='" + user + '\'' +
                ", tendency='" + tendency + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
