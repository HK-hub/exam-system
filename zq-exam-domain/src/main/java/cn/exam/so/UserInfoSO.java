package cn.zq.exam.so;

import lombok.Data;

/**
 * @author YS
 * @version 1.0  注册
 * @date 2021-02-06 9:30
 */
@Data
public class UserInfoSO {
    /**
     * 学号  或 教师号
     */
    private String userId;



    private String typeId;

    /**
     * 密码
     */
    private String password;

    private String userName;

    private String confirmPassword;





}
