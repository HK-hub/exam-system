package cn.exam.controller;

import cn.exam.config.BaseController;
import cn.exam.config.UserUtil;
import cn.exam.dao.mapper.zj.ZjPaperInfoMapper;
import cn.exam.dao.mapper.zj.ZjPaperTestMapper;
import cn.exam.dao.mapper.zj.ZjSubjectUserLinkMapper;
import cn.exam.dao.mapper.zj.ZjTitleInfoMapper;
import cn.exam.domain.zj.ZjPaperTest;
import cn.exam.domain.zj.ZjSubjectInfo;
import cn.exam.domain.zj.ZjSubjectUserLink;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.PaperQuery;
import cn.exam.query.PaperUserQuery;
import cn.exam.service.ExaminationService;
import cn.exam.service.PaperTestService;
import cn.exam.so.PaperSO;
import cn.exam.so.PaperSuccessSO;
import cn.exam.util.*;
import cn.exam.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @Autowired
    private ZjPaperTestMapper paperTestMapper;
    @Autowired
    private ZjPaperInfoMapper paperInfoMapper;


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
        query.setUserId(user.getUserId());
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

    /**
     * 删除试卷
     */
    @RequestMapping("deletePaper.htm")
    public void deletePaper(Integer paperId,HttpServletResponse response){
        List<Integer> integers = testService.queryListIdByPaperId(paperId);
        integers.forEach(f->{
            paperTestMapper.deleteByPrimaryKey(f);
        });
        paperInfoMapper.deleteByPrimaryKey(paperId);
        sendJsonSuccess( response);
    }

    /**
     * 考试提交页面
     * @param successSO
     * @param response
     */
    @RequestMapping("successPaper.htm")
    public void  successPaper(PaperSuccessSO successSO , HttpServletResponse response){
        UserVO user = userUtil.getUser();
        successSO.setUserId(user.getUserId());
        testService.paperEnd(successSO);
        sendJsonSuccess(response);
    }

    /**
     * 成绩查询页面
     */
    @RequestMapping("queryPage.htm")
    public void queryPage(PaperUserQuery query ,HttpServletResponse response){
        ResultDTO<PageResult<List<PaperUserPapage>>> resultDTO = new ResultDTO<>();
        PageResult<List<PaperUserPapage>> listPageResult = testService.queryPaperUser(query);
        resultDTO.setResult(listPageResult);
        resultDTO.buildReturnCode(SystemCode.RET_CODE_SUCC, SystemCode.RET_MSG_SUCC);
        sendJsonSuccessPage(resultDTO, response);
    }


    @RequestMapping("queryAchievement.htm")
    public void queryAchieve(HttpServletResponse response){
        ResultDTO<List<String> > resultDTO = new ResultDTO<>();
        resultDTO.setResult(testService.queryAchievement());
        resultDTO.buildReturnCode(SystemCode.RET_CODE_SUCC, SystemCode.RET_MSG_SUCC);
        sendJsonSuccess(resultDTO, response);
    }


    @RequestMapping("paperExport.htm")
    public void paperExport(Integer paperId,HttpServletResponse response) throws IOException {
        List<PaperExportVO> paperExportVOS = testService.queryPaperExport(paperId);
        PaperExportVO paperExportVO = paperExportVOS.get(0);
        String fileName = paperExportVO.getPaperName()+".xlsx";
        EasyExcelUtil.writeWeb(fileName, PaperExportVO.class, paperExportVOS, response);
    }

    @RequestMapping("queryExport.htm")
    public void quertExport(HttpServletResponse response) throws IOException {
        List<AchievementExportVO> achievementExportVOS = testService.queryExport();
        String fileName = "成绩单.xlsx";
        EasyExcelUtil.writeWeb(fileName, AchievementExportVO.class, achievementExportVOS, response);
    }




}
