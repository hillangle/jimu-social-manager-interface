package com.jimu.social.interfaces.service;

import com.jimu.social.interfaces.domain.Social;

import java.util.List;
import java.util.Map;

public interface ISocialService {

    /**
     * 动态发布
     * @return
     */
    public void save(Social social);

    /**
     * 获取动态分页列表
     * @param map
     * @return Tendency
     */
    List<Social> querySocialList(Map<String, Object> map);

    /**
     * 动态信息修改
     * @param social
     * @return flag
     */
    boolean updateSocial(Social social);

    /**
     * 获取动态分页列表总数
     * @param map
     * @return Tendency
     */
    int count(Map<String, Object> map);
}
