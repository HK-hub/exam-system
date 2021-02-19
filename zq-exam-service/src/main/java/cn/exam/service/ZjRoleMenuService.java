package cn.exam.service;

import cn.exam.vo.MenuInfoVO;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2020-04-28 15:14
 */
public interface ZjRoleMenuService {


    /**
     * 根据角色id
     * @param roleIdList 角色列表
     */
    List<MenuInfoVO> queryMenuList(List<String> roleIdList);





}
