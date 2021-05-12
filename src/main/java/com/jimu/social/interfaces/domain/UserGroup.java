package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 用户兴趣小组关联表
 * @table t_user_group
 * @column unid 主键
 * @column userId 用户主键
 * @column groupId 兴趣小组主键
 * @column status 状态(0-正常 1-隐藏)
 * @column createDate 发布时间
 */
@Data
public class UserGroup {
    public String unid;
    public String userId;
    public String groupId;
    public String status;
    public String createDate;

    public SysUser user;

    public Group group;

    @Override
    public String toString() {
        return "Tendency{ unid=" + unid +
                ", user='" + user + '\'' +
                ", group='" + group + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
