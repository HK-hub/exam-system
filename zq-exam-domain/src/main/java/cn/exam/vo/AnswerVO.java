package cn.exam.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-12 13:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerVO {
    private String label;
    private String value;
}
