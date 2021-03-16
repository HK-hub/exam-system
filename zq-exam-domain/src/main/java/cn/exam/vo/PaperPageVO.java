package cn.exam.vo;

import lombok.Data;

import javax.persistence.Column;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-15 18:50
 */
@Data
public class PaperPageVO {
    private Integer paperId;
    /**
     *
     */
    private String paperName;
    /**
     *
     */
    private Integer subjectId;
    /**
     *
     */
    private String subjectName;
    private Integer difficulty;
    /**
     *
     */
    private String className;
    private Integer classId;
    /**
     *
     */
    private String subType;
    /**
     *
     */
    private String paperDate;
    /**
     *
     */
    private String examDate;
    /**
     *
     */
    private Integer paperNum;
    /**
     *
     */
    private String teachName;
    /**
     *
     */
    private String teachId;
    /**
     *
     */
    private String createTime;
    /**
     *
     */
    private String updateTime;
}
