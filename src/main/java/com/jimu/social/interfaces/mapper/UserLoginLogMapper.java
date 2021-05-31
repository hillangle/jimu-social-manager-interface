package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.UserLoginLog;

import java.util.List;
import java.util.Map;

/**
 * @author liangqi
 * @date 2021/5/26 21:40
 */
public interface UserLoginLogMapper {

    void save(UserLoginLog record);

    List<UserLoginLog> queryUserLoginLogList(Map<String, Object> map);

    int count(Map<String, Object> map);

    List<Map<String, Object>> selectUserLoginLogList(Map<String, Object> map);
}
