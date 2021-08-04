package cn.zq.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @version 1.0
 * @date 2021-01-30 10:48
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
    private Integer id ;
    private String userId;
    private String userName;
    private String roleId;
    private List<String> roleName;
}
