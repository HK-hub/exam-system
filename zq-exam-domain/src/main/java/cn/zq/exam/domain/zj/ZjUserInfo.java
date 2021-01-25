package cn.zq.exam.domain.zj;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @File: ZjUserInfo
 * @Author: ys
 * @Date: 2021-01-25 15:39:00
 * @Description:
 */
@Data
@Table(name = "zj_user_info")
public class ZjUserInfo implements Serializable {
    /**
     * 用户id
     */
    @Id
    @Column(name ="user_id")
    private String userId;
    /**
     * 密码MD5
     */
    @Column(name ="password")
    private String password;
    /**
     * 用户名
     */
    @Column(name ="user_name")
    private String userName;
    /**
     * 是否删除 0 否  1是
     */
    @Column(name ="is_delete")
    private Integer isDelete;
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