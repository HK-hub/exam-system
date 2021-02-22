package cn.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2020-04-30 13:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleMenuVO {
    private Integer id;

    private String label;

    private Integer status;

    private String roleId;


    private List<RoleMenuVO> children;

}
