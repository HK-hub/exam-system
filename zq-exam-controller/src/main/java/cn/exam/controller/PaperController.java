package cn.exam.controller;

import cn.exam.config.BaseController;
import cn.exam.config.UserUtil;
import cn.exam.dao.mapper.zj.ZjPaperTestMapper;
import cn.exam.dao.mapper.zj.ZjSubjectUserLinkMapper;
import cn.exam.dao.mapper.zj.ZjTitleInfoMapper;
import cn.exam.domain.zj.ZjPaperTest;
import cn.exam.domain.zj.ZjSubjectUserLink;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.PaperQuery;
import cn.exam.service.ExaminationService;
import cn.exam.service.PaperTestService;
import cn.exam.util.DateUtil;
import cn.exam.util.PageResult;
import cn.exam.util.ResultDTO;
import cn.exam.util.SystemCode;
import cn.exam.vo.ExamPaperVO;
import cn.exam.vo.PaperPageVO;
import cn.exam.vo.PaperTestLevel;
import cn.exam.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-18 16:39
 */
@Controller
@RequestMapping("paper")
public class PaperController extends BaseController {
    @Autowired
    private ExaminationService examinationService;
    @Autowired
    private UserUtil userUtil;

    @Autowired
    private PaperTestService testService;


    /**
     * 学生考试页面1
     * @param response
     * @param query
     */
    @RequestMapping("queryPaperPage.htm")
    public void queryTitlePage(HttpServletResponse response, PaperQuery query) {
        ResultDTO<PageResult<List<PaperPageVO>>> resultDTO = new ResultDTO<>();
        UserVO user = userUtil.getUser();
        Integer classId = user.getClassId();
        query.setClassId(classId);
        PageResult<List<PaperPageVO>> listPageResult = examinationService.queryPage(query);
        resultDTO.setResult(listPageResult);
        resultDTO.buildReturnCode(SystemCode.RET_CODE_SUCC, SystemCode.RET_MSG_SUCC);
        sendJsonSuccessPage(resultDTO, response);
    }

    /**
     * 点击考试触发按钮
     */
    @RequestMapping("addPaperByStudent.htm")
    public void addPaperByStudent(Integer paperId,HttpServletResponse response){
        UserVO user = userUtil.getUser();
        ResultDTO<PaperTestLevel> resultDTO = new ResultDTO<>();
        resultDTO.setResult(testService.paperTest(paperId, user.getUserId()));
        resultDTO.buildReturnCode(SystemCode.RET_CODE_SUCC, SystemCode.RET_MSG_SUCC);
        sendJsonSuccess(resultDTO, response);

    }



}
