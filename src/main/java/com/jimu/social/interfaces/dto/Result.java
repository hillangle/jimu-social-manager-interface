package com.jimu.social.interfaces.dto;

import lombok.Data;

@Data
public class Result {
    public String resultCode;
    public String resultMsg;
    public String resultData;
    public int httpCode;

}
