package cn.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-12 13:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaperVO {
    private String title;
    private String value;
    private Integer fraction;
    private List<AnswerVO> item;

}
