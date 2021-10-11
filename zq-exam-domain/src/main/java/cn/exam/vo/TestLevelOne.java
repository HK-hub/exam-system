package cn.exam.vo;

import lombok.Data;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-19 13:41
 */
@Data
public class TestLevelOne {
    private Integer id;
    /**
     * 题目
     */
    private String titleName;
    /**
     * 分数
     */
    private Integer titleFraction;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String answer;
    //学生答案
    private String studentAnswers;
}
