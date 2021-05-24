package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Activity;
import com.jimu.social.interfaces.domain.Atta;
import com.jimu.social.interfaces.domain.TendencyAtta;
import com.jimu.social.interfaces.domain.UserAtta;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttaMapper {
    /**
     * 文件上传
     */
    public void save(Atta map);

    /**
     * 用户文件关联
     */
    public void saveUserAtta(UserAtta userAtta);

    /**
     * 修改附件
     */
    public void updateAtta(Map<String, Object> map);

    /**
     * 根据用户id查询关联附件
     */
    public List<Atta> queryAttaByUserId(Map<String, Object> map);

    /**
     * 动态文件关联
     */
    public void saveTendencyAtta(TendencyAtta tendencyAtta);
}
