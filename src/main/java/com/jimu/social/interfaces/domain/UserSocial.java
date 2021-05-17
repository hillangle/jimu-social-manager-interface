package com.jimu.social.interfaces.domain;

import lombok.Data;

@Data
public class UserSocial {
    public String unid;
    public String userUnid;
    public String socialUnid;
    public String link;
    public String status;
    public String createDate;

    @Override
    public String toString() {
        return "Tendency{ unid=" + unid +
                ", userUnid='" + userUnid + '\'' +
                ", socialUnid='" + socialUnid + '\'' +
                ", link='" + link + '\'' +
                ", status='" + status + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
