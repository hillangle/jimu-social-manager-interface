package com.jimu.social.interfaces.service;

import com.jimu.social.interfaces.domain.Tendency;

import java.util.List;
import java.util.Map;

public interface ITendencyService {

    /**
     * 动态发布
     * @return
     */
    public void save(Tendency tendency);

    /**
     * 获取动态分页列表
     * @param map
     * @return Tendency
     */
    List<Tendency> queryTendencyList(Map<String, Object> map);

    /**
     * 动态信息修改
     * @param tendency
     * @return flag
     */
    boolean updateTendency(Tendency tendency);

    /**
     * 获取动态分页列表总数
     * @param map
     * @return Tendency
     */
    int count(Map<String, Object> map);
}
