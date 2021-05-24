package com.jimu.social.interfaces.service;

import com.jimu.social.interfaces.domain.Discuss;
import com.jimu.social.interfaces.domain.Tendency;
import com.jimu.social.interfaces.domain.TendencyUserZan;

import java.util.List;
import java.util.Map;

public interface ITendencyService {

    /**
     * 动态发布
     * @return
     */
    boolean save(Map<String, Object> map);

    /**
     * 获取动态分页列表
     * @param map
     * @return Tendency
     */
    List<Tendency> queryTendencyList(Map<String, Object> map);

    /**
     * 获取动态分页列表
     * @param map
     * @return Tendency
     */
    TendencyUserZan queryZanByUserId(Map<String, Object> map);

    /**
     * 获取全部动态分页列表
     * @param map
     * @return Tendency
     */
    List<Tendency> queryAllTendencyList(Map<String, Object> map);

    /**
     * 动态信息修改
     * @param tendency
     * @return flag
     */
    boolean updateTendency(Tendency tendency);

    /**
     * 赞添加
     * @param tendencyUserZan
     * @return flag
     */
    boolean saveZan(TendencyUserZan tendencyUserZan);

    /**
     * 赞状态修改
     * @param tendencyUserZan
     * @return flag
     */
    boolean updateZan(TendencyUserZan tendencyUserZan);

    /**
     * 获取动态分页列表总数
     * @param map
     * @return Tendency
     */
    int count(Map<String, Object> map);

    /**
     * 评论添加
     * @param tendencyUserZan
     * @return flag
     */
    boolean savePl(Discuss discuss);
}
