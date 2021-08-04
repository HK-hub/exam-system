package cn.exam.service;

import cn.exam.domain.zj.ZjUserInfo;
import cn.exam.query.UserQuery;
import cn.exam.util.PageResult;
import cn.exam.vo.UserPageVO;
import cn.exam.vo.UserVO;

import java.util.List;

/**
 * @version 1.0
 * @date 2021-02-02 14:38
 */
public interface UserInfoService {

    UserVO queryUserInfoByName(String userId);


    PageResult<List<UserPageVO>>queryPage(UserQuery  query );
}
