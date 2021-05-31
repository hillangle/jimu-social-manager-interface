package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.UserLoginLog;

import java.util.List;
import java.util.Map;

public interface IUserLoginLogService {

    /**
     * 新增用户登录记录
     * @return
     */
    public void save(UserLoginLog userLoginLog);

    /**
     * 获取用户登录记录分页列表
     * @param map
     * @return Tendency
     */
    List<UserLoginLog> queryUserLoginLogList(Map<String, Object> map);

    /**
     * 获取用户登录记录分页列表总数
     * @param map
     * @return UserLoginLog
     */
    int count(Map<String, Object> map);

    /**
     * 获取用户登录记录统计列表
     * @param map
     * @return Tendency
     */
    List<Map<String, Object>> selectUserLoginLogList(Map<String, Object> map);

}
