package cn.exam.domain.zj;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @File: ZjPaperInfo
 * @Author: ys
 * @Date: 2021-03-12 13:30:09
 * @Description:
 */
@Data
@Table(name = "zj_paper_info")
public class ZjPaperInfo implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name ="paper_id")
    private Integer paperId;
    /**
     *
     */
    @Column(name ="paper_name")
    private String paperName;
    /**
     *
     */
    @Column(name ="subject_id")
    private Integer subjectId;
    /**
     *
     */
    @Column(name ="difficulty")
    private Integer difficulty;
    /**
     *
     */
    @Column(name ="class_id")
    private Integer classId;
    /**
     *
     */
    @Column(name ="sub_type")
    private String subType;
    /**
     *
     */
    @Column(name ="paper_date")
    private String paperDate;
    /**
     *
     */
    @Column(name ="exam_date")
    private String examDate;
    /**
     *
     */
    @Column(name ="paper_num")
    private Integer paperNum;
    /**
     *
     */
    @Column(name ="teach_name")
    private String teachName;
    /**
     *
     */
    @Column(name ="teach_id")
    private String teachId;
    /**
     *
     */
    @Column(name ="create_time")
    private String createTime;
    /**
     *
     */
    @Column(name ="update_time")
    private String updateTime;
}
