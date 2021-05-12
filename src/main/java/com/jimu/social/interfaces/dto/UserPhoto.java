package com.jimu.social.interfaces.dto;

import lombok.Data;

@Data
public class UserPhoto {
    String attaName;
    String attaType;
    String attaPath;
    String fileType;

    @Override
    public String toString() {
        return "UserPhoto{ attaName=" + attaName +
                ", attaType='" + attaType + '\'' +
                ", attaPath='" + attaPath + '\'' +
                ", fileType='" + fileType + '\'' +'}';
    }
}
