package cn.exam.query;

import lombok.Data;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:08
 */
@Data
public class TitlePageQuery extends BaseQuery {
    private String titleName;
    private String subjectName;
    private String className;
    private String titleType;
    private String titleFraction;

}
