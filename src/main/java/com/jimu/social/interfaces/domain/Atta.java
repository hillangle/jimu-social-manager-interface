package com.jimu.social.interfaces.domain;

import lombok.Data;
/**
 * 附件表
     * @table t_atta
 * @column unid 主键
 * @column atta_name 文件名称
 * @column atta_type 文件类型
 * @column atta_path 文件路径
 * @column status 状态（0-正常 1-已删除）
 * @column create_date 创建日期
 */
@Data
public class Atta {
    public String attaUnid;
    public String attaName;
    public String attaType;
    public String attaPath;
    public String status;
    public String createDate;

    @Override
    public String toString() {
        return "Atta{ attaUnid=" + attaUnid +
                ", attaName='" + attaName + '\'' +
                ", attaType='" + attaType + '\'' +
                ", attaPath='" + attaPath + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
