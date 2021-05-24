package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Discuss;
import com.jimu.social.interfaces.domain.Tendency;
import com.jimu.social.interfaces.domain.TendencyUserZan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TendencyMapper {
    /**
     * 动态发布
     * @return
     */
    public void save(Map<String, Object> map);

    /**
     * 添加赞
     * @return
     */
    public void saveZan(TendencyUserZan tendencyUserZan);

    /**
     * 添加赞
     * @return
     */
    public void savePl(Discuss discuss);

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
     * 动态信息修改
     * @param tendency
     * @return flag
     */
    boolean updateZan(TendencyUserZan tendencyUserZan);

    /**
     * 获取动态分页列表总数
     * @param map
     * @return Tendency
     */
    int count(Map<String, Object> map);
}
