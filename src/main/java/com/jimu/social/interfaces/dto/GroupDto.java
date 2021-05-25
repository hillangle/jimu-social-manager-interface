package com.jimu.social.interfaces.dto;

import lombok.Data;

@Data
public class GroupDto {
    public String unid;
    public String name;
    public byte[] img;
    public String status;
    public String createDate;
    public int count;

    @Override
    public String toString() {
        return "Group{ unid=" + unid +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                ", count='" + count + '\'' +
                ", createDate='" + createDate + '\'' +'}';
    }
}
