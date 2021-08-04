package cn.exam.query;


import lombok.Data;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-30 13:19
 */
@Data
public class PaperUserQuery extends BaseQuery {
    private String paperName;
    private String userName;
    private String className;
}
