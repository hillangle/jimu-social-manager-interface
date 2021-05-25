package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.Group;
import com.jimu.social.interfaces.domain.UserGroup;
import com.jimu.social.interfaces.dto.GroupDto;
import com.jimu.social.interfaces.mapper.GroupMapper;
import com.jimu.social.interfaces.service.IGroupService;
import com.jimu.social.interfaces.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class GroupServiceImpl implements IGroupService {
    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void save(Group group) {
        groupMapper.save(group);
    }

    @Override
    public List<Group> queryGroupList(Map<String, Object> map) {
        try {
           return groupMapper.queryGroupList(map);
        } catch(Exception e){
            log.error("获取兴趣小组列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<GroupDto> queryGroupListWithUserCount(Map<String, Object> map) {
        try {
           return groupMapper.queryGroupListWithUserCount(map);
        } catch(Exception e){
            log.error("获取兴趣小组列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public List<GroupDto> queryUserGroup(Map<String, Object> map) {
        try {
            return groupMapper.queryUserGroup(map);
        } catch(Exception e){
            log.error("获取兴趣小组列表失败,失败原因{}",e);
            return null;
        }
    }

    @Override
    public boolean updateGroup(Group group) {
        try{
            groupMapper.updateGroup(group);
            return true;
        }catch(Exception e) {
            log.error("修改兴趣小组信息失败,失败原因{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return groupMapper.count(map);
        }catch(Exception e) {
            log.error("根据条件统计兴趣小组数量失败,失败原因{}",e);
            return 0;
        }
    }

    @Override
    public boolean joinOrOutGroup(UserGroup query){
        try{
            UserGroup userGroup = groupMapper.queryUserGroupRelation(query);
            if(userGroup == null){
                query.setCreateDate(DateUtils.getDateByString());
                groupMapper.saveUserGroup(query);
            }else{
                userGroup.setStatus(query.getStatus());
                groupMapper.updateUserGroup(userGroup);
            }
            return true;
        }catch(Exception e){
            log.error("关联用户和兴趣小组失败,失败原因{}",e);
            return false;
        }
    }
}
