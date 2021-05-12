package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Activity;
import com.jimu.social.interfaces.domain.Atta;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttaMapper {
    /**
     * 文件上传
     */
    public void save(Map<String, Object> map);

    /**
     * 用户文件关联
     */
    public void saveUserAtta(Map<String, Object> map);

    /**
     * 修改附件
     */
    public void updateAtta(Map<String, Object> map);

    /**
     * 根据用户id查询关联附件
     */
    public List<Atta> queryAttaByUserId(Map<String, Object> map);
}
