package cn.exam.controller;

import cn.exam.config.BaseController;
import cn.exam.domain.zj.ZjMenuInfo;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.TitlePageQuery;
import cn.exam.service.ExaminationService;
import cn.exam.util.PageResult;
import cn.exam.util.ResultDTO;
import cn.exam.util.SystemCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:30
 */
@Controller
@RequestMapping("title")
public class ExaminationController extends BaseController {

    @Autowired
    private ExaminationService examinationService;


    @RequestMapping("queryTitlePage.htm")
    public void queryTitlePage(HttpServletResponse response, TitlePageQuery query){
        ResultDTO<PageResult<List<ZjTitleInfo>>> resultDTO = new ResultDTO<>();
        PageResult<List<ZjTitleInfo>> listPageResult = examinationService.queryPage(query);
        resultDTO.setResult(listPageResult);
        resultDTO.buildReturnCode(SystemCode.RET_CODE_SUCC,SystemCode.RET_MSG_SUCC);
        sendJsonSuccessPage(resultDTO,response);
    }






}
