package cn.exam.service;

import cn.exam.vo.PaperTestLevel;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-19 13:37
 */
public interface PaperTestService {

    PaperTestLevel paperTest(Integer paperId,String userId);


}
