package com.jimu.social.interfaces.service;

import com.jimu.social.interfaces.domain.SysUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Map;

public interface ISysUserService extends UserDetailsService {

    /**
     * 注册系统用户
     * @return
     */
    public void save(SysUser user);

    /**
     * 根据用户名获取用户信息用户
     * @return
     */
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    /**
     * 根据用户名获取用户信息用户
     * @return
     */
    SysUser queryUserByAccount(String s);

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
     * 用户信息修改
     * @param map
     * @return flag
     */
    boolean updateSysUser(Map<String, Object> map);

    /**
     * 根据条件获取用户分页列表总数
     * @param map
     * @return SysUser
     */
    int count(Map<String, Object> map);

}
