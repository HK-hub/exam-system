package cn.exam.vo;

import lombok.Data;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-19 13:30
 */
@Data
public class PaperTestVO {
    private Integer id;
    private Integer titleId;
    private String titleName;
    private Integer titleStatus;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Integer titleFraction;
    private String paperName;
    private Integer examDate;
    private String userName;
}
