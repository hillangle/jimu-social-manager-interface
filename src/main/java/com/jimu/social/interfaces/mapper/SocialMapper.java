package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Social;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SocialMapper {
    /**
     * 社交平台发布
     * @return
     */
    public void save(Social social);

    /**
     * 获取社交平台分页列表
     * @param map
     * @return Social
     */
    List<Social> querySocialList(Map<String, Object> map);

    /**
     * 社交平台信息修改
     * @param social
     * @return flag
     */
    boolean updateSocial(Social social);

    /**
     * 获取社交平台分页列表总数
     * @param map
     * @return Social
     */
    int count(Map<String, Object> map);
}
