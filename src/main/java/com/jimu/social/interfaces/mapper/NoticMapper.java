package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Notic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface NoticMapper {
    /**
     * 公告发布
     * @return
     */
    public void save(Notic notic);

    /**
     * 获取公告列表
     * @param map
     * @return Notic
     */
    List<Notic> queryNoticList(Map<String, Object> map);

    /**
     * 获取公告分页列表
     * @param map
     * @return Notic
     */
    List<Notic> queryNoticPage(Map<String, Object> map);

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
