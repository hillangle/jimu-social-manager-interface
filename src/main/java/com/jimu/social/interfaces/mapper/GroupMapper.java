package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Group;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GroupMapper {
    /**
     * 社交平台发布
     * @return
     */
    public void save(Group social);

    /**
     * 获取社交平台分页列表
     * @param map
     * @return Social
     */
    List<Group> queryGroupList(Map<String, Object> map);

    /**
     * 社交平台信息修改
     * @param group
     * @return flag
     */
    boolean updateGroup(Group group);

    /**
     * 获取社交平台分页列表总数
     * @param map
     * @return Social
     */
    int count(Map<String, Object> map);
}
