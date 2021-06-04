package com.jimu.social.interfaces.mapper;

import com.jimu.social.interfaces.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper{

    /**
     * 注册系统用户
     * @return
     */
    void saveSysUser(SysUser user);

    /**
     * 根据用户名获取用户信息
     * @param account
     * @return SysUser
     */
    SysUser queryUserByAccount(String account);

    /**
     * 根据用户角色获取用户分页列表
     * @param map
     * @return SysUser
     */
    List<SysUser> queryUserList(Map<String, Object> map);

    /**
     * 根据用户角色获取用户分页列表
     * @param map
     * @return SysUser
     */
    List<SysUser> queryUserPage(Map<String, Object> map);

    /**
     * 根据用户名获取用户相关信息
     * @param map
     * @return SysUser
     */
    List<SysUser> queryUserInfo(Map<String, Object> map);

    /**
     * 根据条件获取用户分页列表总数
     * @param map
     * @return SysUser
     */
    int count(Map<String, Object> map);

    /**
     * 用户信息修改
     * @param sysUser
     * @return flag
     */
    boolean updateSysUser(Map<String, Object> map);
}
