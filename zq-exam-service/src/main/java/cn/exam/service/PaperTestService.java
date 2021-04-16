package cn.exam.service;

import cn.exam.domain.zj.ZjSubjectInfo;
import cn.exam.query.PaperQuery;
import cn.exam.query.PaperUserQuery;
import cn.exam.query.SubjectQuery;
import cn.exam.so.PaperSuccessSO;
import cn.exam.util.PageResult;
import cn.exam.vo.AchievementExportVO;
import cn.exam.vo.PaperExportVO;
import cn.exam.vo.PaperTestLevel;
import cn.exam.vo.PaperUserPapage;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-19 13:37
 */
public interface PaperTestService {

    PaperTestLevel paperTest(Integer paperId,String userId);

    List<Integer> queryListIdByPaperId(Integer paperId);

    void paperEnd(PaperSuccessSO successSO);

    PageResult<List<PaperUserPapage>> queryPaperUser(PaperUserQuery query);
    List<String> queryAchievement();

    /**
     * 试卷导出
     */
    List<PaperExportVO> queryPaperExport(Integer paperId);

    /**
     * 成绩导出
     * @return
     */
    List<AchievementExportVO> queryExport();



}
