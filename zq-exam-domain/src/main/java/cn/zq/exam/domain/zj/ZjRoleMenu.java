package cn.zq.exam.domain.zj;
/**
 * @File: ZjRoleMenu
 * @Author: ys
 * @Date: 2021-01-25 15:38:32
 * @Description:
 */
@Data
@Table(name = "zj_role_menu")
public class ZjRoleMenu implements Serializable {
    /**
     * 主键
     */
    @Column(name ="id")
    private Integer id;
    /**
     * 角色id
     */
    @Column(name ="role_id")
    private String roleId;
    /**
     * 菜单id
     */
    @Column(name ="menu_id")
    private Integer menuId;
    /**
     * 开始时间
     */
    @Column(name ="create_time")
    private String createTime;
    /**
     * 结束时间
     */
    @Column(name ="update_time")
    private String updateTime;
}