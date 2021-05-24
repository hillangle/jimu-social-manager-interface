package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 动态表
 * @table t_tendency_user_zan
 * @column zan_unid 主键
 * @column userId 用户主键
 * @column tendencyId 动态主键
 * @column content 内容
 * @column status 状态(0-正常 1-隐藏)
 * @column createDate 发布时间
 */
@Data
public class TendencyUserZan {
    public String unid;
    public String userId;
    public String tendencyId;
    public String status;
    public String createDate;

    @Override
    public String toString() {
        return "Tendency{ unid=" + unid +
                ", userId='" + userId + '\'' +
                ", tendencyId='" + tendencyId + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
