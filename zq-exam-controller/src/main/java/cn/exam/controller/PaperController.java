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
import cn.exam.util.DateUtil;
import cn.exam.util.PageResult;
import cn.exam.util.ResultDTO;
import cn.exam.util.SystemCode;
import cn.exam.vo.PaperPageVO;
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
    private ZjTitleInfoMapper titleInfoMapper;
    @Autowired
    private ZjSubjectUserLinkMapper userLinkMapper;
    @Autowired
    private ZjPaperTestMapper paperTestMapper;


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
        List<ZjSubjectUserLink> zjSubjectUserLinks = userLinkMapper.queryByList(paperId);
        List<Integer> titleIdList = new ArrayList<>();
        if (!ObjectUtils.isEmpty(zjSubjectUserLinks)){
            zjSubjectUserLinks.forEach(f->{
                titleIdList.add(f.getTitleId());
            });
        }
        UserVO user = userUtil.getUser();
        ZjSubjectUserLink userLink = zjSubjectUserLinks.get(0);
        List<ZjTitleInfo> zjTitleInfos = titleInfoMapper.queryListByTitleId(titleIdList);
        List<ZjPaperTest> paperTests = new ArrayList<>();
        zjTitleInfos.forEach(f->{
            ZjPaperTest paperTest = new ZjPaperTest();
            paperTest.setTitleAnswer(f.getTitleAnswer());
            paperTest.setClassId(userLink.getClassId());
            paperTest.setPaperId(paperId);
            paperTest.setTitleFraction(f.getTitleFraction());
            paperTest.setTitleId(f.getTitleId());
            paperTest.setUserId(user.getUserId());
            paperTest.setUserName(user.getUserName());
            paperTest.setCreateTime(DateUtil.getCurrentDateTime());
            paperTests.add(paperTest);
        });
        paperTestMapper.insertList(paperTests);
        sendJsonSuccess(response);
    }



}
