package cn.exam.service;

import cn.exam.vo.UserVO;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-02 14:38
 */
public interface UserInfoService {

    UserVO queryUserInfoByName(String userId);
}
