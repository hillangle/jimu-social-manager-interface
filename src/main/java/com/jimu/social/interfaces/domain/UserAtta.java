package com.jimu.social.interfaces.domain;

import lombok.Data;

/**
 * 附件关联表表
 * @table t_user_atta
 * @column unid 主键
 * @column atta_unid 附件主键
 * @column user_unid 用户主键
 * @column atta_type 附件类型（0-头像 1-个人照片 2-其他）
 * @column status 状态（0-正常 1-已删除）
 * @column create_date 创建日期
 */
@Data
public class UserAtta {
    public String unid;
    public String attaUnid;
    public String userUnid;
    public String attaType;
    public String status;
    public String createDate;

    @Override
    public String toString() {
        return "Atta{ unid=" + unid +
                ", attaUnid='" + attaUnid + '\'' +
                ", userUnid='" + userUnid + '\'' +
                ", attaType='" + attaType + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
