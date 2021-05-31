package com.jimu.social.interfaces.service;

import com.jimu.social.interfaces.domain.Social;
import com.jimu.social.interfaces.domain.UserSocial;

import java.util.List;
import java.util.Map;

public interface ISocialService {

    /**
     * 平台新增
     * @return
     */
    public void save(Social social);

     /**
     * 用户关联平台新增
     * @return
     */
    public void saveUserSocial(UserSocial userSocial);

    /**
     * 获取平台分页列表
     * @param map
     * @return Tendency
     */
    List<Social> querySocialList(Map<String, Object> map);

    /**
     * 根据登录用户获取绑定平台列表
     * @param map
     * @return Tendency
     */
    List<Social> queryUserSocial(Map<String, Object> map);

    /**
     * 平台信息修改
     * @param social
     * @return flag
     */
    boolean updateSocial(Social social);

    /**
     * 平台信息修改
     * @param userSocial
     * @return flag
     */
    boolean updateUserSocial(UserSocial userSocial);

    /**
     * 获取平台分页列表总数
     * @param map
     * @return Social
     */
    int count(Map<String, Object> map);

    /**
    * @Description: 平台收藏统计
    * @Param: [params]
    * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    * @Author: liangqi
    * @Date: 2021/5/31 22:11
    */
    List<Map<String, Object>> selectUserSocialList(Map<String, Object> params);
}
