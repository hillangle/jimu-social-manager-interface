package com.jimu.social.interfaces.service.impl;

import com.jimu.social.interfaces.domain.SysUser;
import com.jimu.social.interfaces.dto.Result;
import com.jimu.social.interfaces.mapper.SysUserMapper;
import com.jimu.social.interfaces.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RestControllerAdvice
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public void save(SysUser user) {
        sysUserMapper.saveSysUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            SysUser sysUser = sysUserMapper.queryUserByAccount(s);
            if (sysUser == null) {
                return null;
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(sysUser.getUserRole()));
            //封装 SpringSecurity  需要的UserDetails 对象并返回
            UserDetails userDetails = new User(sysUser.getAccount(), sysUser.getPassword(), authorities);
            return userDetails;
        } catch(Exception e){
            log.error("根据用户名获取用户信息失败,失败原因:{}",e);
            return null;
        }
    }

    @Override
    public SysUser queryUserByAccount(String s) {
        try {
            SysUser sysUser = sysUserMapper.queryUserByAccount(s);
            if (sysUser == null) {
                return null;
            }
            return sysUser;
        } catch(Exception e){
            log.error("根据用户名获取用户信息失败,失败原因:{}",e);
            return null;
        }
    }

    @Override
    public List<SysUser> queryUserList(Map<String, Object> map) {
        try{
            return sysUserMapper.queryUserList(map);
        }catch(Exception e){
            log.error("根据用户角色获取用户分页列表失败,失败原因:{}",e);
            return null;
        }
    }

    @Override
    public List<SysUser> queryUserInfo(Map<String, Object> map) {
        try{
            return sysUserMapper.queryUserInfo(map);
        }catch(Exception e){
            log.error("根据用户角色获取用户分页列表失败,失败原因:{}",e);
            return null;
        }
    }

    @Override
    public boolean updateSysUser(Map<String, Object> map){
        try{
            sysUserMapper.updateSysUser(map);
            return true;
        }catch(Exception e){
            log.error("用户信息修改失败,失败原因:{}",e);
            return false;
        }
    }

    @Override
    public int count(Map<String, Object> map) {
        try{
            return sysUserMapper.count(map);
        }catch(Exception e){
            log.error("根据条件统计用户数量失败,失败原因:{}",e);
            return 0;
        }
    }
}
