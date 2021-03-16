package cn.exam.service;

import cn.exam.domain.zj.ZjPaperInfo;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.PaperQuery;
import cn.exam.query.TitlePageQuery;
import cn.exam.util.PageResult;
import cn.exam.util.PageUtil;
import cn.exam.vo.ExamPaperVO;
import cn.exam.vo.PaperPageVO;
import cn.exam.vo.TitleVO;
import cn.exam.vo.UserVO;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:03
 */
public interface ExaminationService {

    //试卷管理分页
    PageResult<List<PaperPageVO>> queryPage (PaperQuery query);


    PageResult<List<TitleVO>> queryPage(TitlePageQuery query);

    void insertTitle(ZjTitleInfo info, UserVO user);

    TitleVO queryTitleInfo(Integer titleId);

    void deleteTitle(Integer titleId);

    void updateTitle(ZjTitleInfo info);

    //试卷页面
    List<ExamPaperVO> queryPaper(Integer paperId);
    //自动组卷
    void audioPaper(ZjPaperInfo paperInfo);



}
