package cn.exam.service.impl;

import cn.exam.service.UserInfoService;
import cn.exam.vo.UserRoleVO;
import cn.exam.dao.mapper.zj.ZjUserInfoMapper;

import cn.exam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-02 14:37
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private ZjUserInfoMapper userMapper;


    @Override
    public UserVO queryUserInfoByName(String userId) {
//        UserVO user = userMapper.queryShiroUserInfoByUserName(userId);

        UserVO user = userMapper.queryShiroUserInfoByUserName();

//        List<UserRoleVO> roleBean = userMapper.queryUserRoleByUserId(userId);
//        user.setRole(roleBean);
//        return user;

        return  null;
    }
}
