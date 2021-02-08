/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjUserInfo;
import cn.exam.vo.UserRoleVO;
import cn.exam.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;


/**
 * @File: ZjUserInfo
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjUserInfoMapper extends CommonBaseMapper<ZjUserInfo> {
    @Select("select  user_id,password,user_name from zj_user_info where user_id =#{userId} and is_delete=0")
    UserVO queryShiroUserInfoByUserName(@Param("userId") String userId);


    /**
     * userId查询权限
     * @param userId 用户id
     */
    @Select("SELECT   a.user_id ,a.role_id ,b.role_name FROM zj_user_role a LEFT JOIN zj_role b ON a.role_id = b.role_id WHERE a.user_id=#{userId}")
    List<UserRoleVO> queryUserRoleByUserId(@Param("userId")String userId);






}