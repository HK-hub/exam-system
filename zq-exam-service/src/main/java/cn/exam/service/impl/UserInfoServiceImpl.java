package cn.exam.service.impl;

import cn.exam.domain.zj.ZjUserInfo;
import cn.exam.query.UserQuery;
import cn.exam.service.UserInfoService;
import cn.exam.util.PageResult;
import cn.exam.util.PageUtil;
import cn.exam.vo.UserRoleVO;
import cn.exam.dao.mapper.zj.ZjUserInfoMapper;

import cn.exam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
        UserVO user = userMapper.queryShiroUserInfoByUserName(userId);
        List<UserRoleVO> roleBean = userMapper.queryUserRoleByUserId(userId);
        if (!ObjectUtils.isEmpty(roleBean)){
            user.setRole(roleBean);
        }
        return user;
    }

    @Override
    public PageResult<List<ZjUserInfo>> queryPage(UserQuery query) {
        return PageUtil.execute(() -> userMapper.queryPage(query), query);
    }
}
