package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.Group;

import java.util.List;
import java.util.Map;

public interface IGroupService {

    /**
     * 兴趣小组添加
     * @return
     */
    public void save(Group group);

    /**
     * 获取兴趣小组分页列表
     * @param map
     * @return Tendency
     */
    List<Group> queryGroupList(Map<String, Object> map);

    /**
     * 根据用户登录名获取关联兴趣小组列表
     * @param map
     * @return Tendency
     */
    List<Group> queryUserGroup(Map<String, Object> map);

    /**
     * 兴趣小组信息修改
     * @param group
     * @return flag
     */
    boolean updateGroup(Group group);

    /**
     * 获取兴趣小组分页列表总数
     * @param map
     * @return Group
     */
    int count(Map<String, Object> map);
}
