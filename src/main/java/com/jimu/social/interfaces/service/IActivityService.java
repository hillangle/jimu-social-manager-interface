package com.jimu.social.interfaces.service;


import com.jimu.social.interfaces.domain.Activity;

import java.util.List;
import java.util.Map;

public interface IActivityService {

    /**
     * 活动添加
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
     * 获取活动分页列表
     * @param map
     * @return Activity
     */
    List<Activity> queryActivityPage(Map<String, Object> map);

    /**
     * 活动信息修改
     * @param activity
     * @return flag
     */
    boolean updateActivity(Activity activity);

    /**
     * 获取活动分页列表总数
     * @param map
     * @return Activity
     */
    int count(Map<String, Object> map);
}
