package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.Activity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ActivityMapper {
    /**
     * 活动发布
     * @return
     */
    public void save(Activity activity);

    /**
     * 获取活动分页列表
     * @param map
     * @return Activity
     */
    List<Activity> queryActivityList(Map<String, Object> map);

    /**
     * 活动信息修改
     * @param activity
     * @return flag
     */
    boolean updateActivity(Activity activity);

    /**
     * 获取活动分页列表总数
     * @param map
     * @return activity
     */
    int count(Map<String, Object> map);
}
