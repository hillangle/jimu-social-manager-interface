package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.Notic;

import java.util.List;
import java.util.Map;

public interface INoticService {

    /**
     * 新增公告
     * @return
     */
    public void save(Notic notic);

    /**
     * 获取公告分页列表
     * @param map
     * @return Tendency
     */
    List<Notic> queryNoticList(Map<String, Object> map);

    /**
     * 公告信息修改
     * @param notic
     * @return flag
     */
    boolean updateNotic(Notic notic);

    /**
     * 获取公告分页列表总数
     * @param map
     * @return Notic
     */
    int count(Map<String, Object> map);
}
