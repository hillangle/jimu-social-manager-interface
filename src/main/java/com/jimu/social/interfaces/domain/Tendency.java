package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 动态表
 * @table t_tendency
 * @column unid 主键
 * @column userId 用户主键
 * @column groupId 兴趣小组主键
 * @column content 内容
 * @column status 状态(0-正常 1-隐藏)
 * @column createDate 发布时间
 */
@Data
public class Tendency {
    public String unid;
    public String userId;
    public String groupId;
    public String content;
    public String status;
    public String createDate;

    public SysUser user;

    public Group group;

    public List<Atta> attas;

    @Override
    public String toString() {
        return "Tendency{ unid=" + unid +
                ", user='" + user + '\'' +
                ", group='" + group + '\'' +
                ", content='" + content + '\'' +
                ", attas='" + attas + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
