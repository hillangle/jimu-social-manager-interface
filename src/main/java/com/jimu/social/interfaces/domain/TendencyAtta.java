package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 动态表
 * @table t_tendency_atta
 * @column unid 主键
 * @column tendencyId 用户主键
 * @column attaId 兴趣小组主键
 * @column status 状态(0-正常 1-隐藏)
 * @column createDate 发布时间
 */
@Data
public class TendencyAtta {
    public String unid;
    public String tendencyId;
    public String attaId;
    public String status;
    public String createDate;

    public Tendency tendency;

    public Atta atta;

    @Override
    public String toString() {
        return "TendencyAtta{ unid=" + unid +
                ", tendency='" + tendency + '\'' +
                ", atta='" + atta + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
