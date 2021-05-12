package com.jimu.social.interfaces.domain;

import lombok.Data;

import java.util.List;

/**
 * 系统用户表
 * @table t_user
 * @column unid 主键
 * @column user_name 系统用户姓名
 * @column account 系统用户登录名
 * @column password 系统用户密码
 * @column user_role 系统用户所属角色
 * @column sex 性别(0-未知 1-男 2-女)
 * @column telphone 手机号
 * @column birthday 生日
 * @column remark 签名
 * @column status 状态（0-正常 1-封号）
 * @column create_date 注册日期
 */
@Data
public class SysUser {
    public Integer unid;
    public String userName;
    public String account;
    public String password;
    public String userRole;
    public String sex;
    public String telphone;
    public String birthday;
    public String remark;
    public String status;
    public String createDate;
    public String userAttaId;

    public List<Atta> userPhotos;
    public List<Social> socials;

    @Override
    public String toString() {
        return "User{ unid=" + unid +
            ", userName='" + userName + '\'' +
            ", account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", userRole='" + userRole + '\'' +
            ", sex='" + sex + '\'' +
            ", telphone='" + telphone + '\'' +
            ", birthday='" + birthday + '\'' +
            ", remark='" + remark + '\'' +
            ", status='" + status + '\'' +
            ", socials='" + socials + '\'' +
            ", userPhotos='" + userPhotos + '\'' +
            ", createDate='" + createDate + '\'' +'}';
    }

}
