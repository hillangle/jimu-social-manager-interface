package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Group;
import com.jimu.social.interfaces.domain.UserGroup;
import com.jimu.social.interfaces.dto.GroupDto;
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
     * 获取社交平台列表
     * @param map
     * @return Social
     */
    List<GroupDto> queryGroupListWithUserCount(Map<String, Object> map);

    /**
     * 根据用户登录名获取关联兴趣小组列表
     * @param map
     * @return Tendency
     */
    List<GroupDto> queryUserGroup(Map<String, Object> map);

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

    /**
     * 获取用户与兴趣小组关联数据
     * @param userGroup
     * @return Social
     */
    UserGroup queryUserGroupRelation(UserGroup userGroup);

    /**
     * 添加用户与兴趣小组关联
     * @param userGroup
     * @return Social
     */
    boolean saveUserGroup(UserGroup userGroup);

    /**
     * 修改用户与兴趣小组关联
     * @param userGroup
     * @return Social
     */
    boolean updateUserGroup(UserGroup userGroup);
}
