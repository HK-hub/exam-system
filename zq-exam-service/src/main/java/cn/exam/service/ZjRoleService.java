package cn.exam.service;

import cn.exam.domain.zj.ZjRole;
import cn.exam.query.RoleQuery;
import cn.exam.util.PageResult;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-21 17:06
 */
public interface ZjRoleService {
    /**
     * 分页
     */
    PageResult<List<ZjRole>> queryPage(RoleQuery query);


    void insertRoleInfo(ZjRole role);

    void deleteRole(Integer id);
}
