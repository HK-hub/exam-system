package cn.exam.service.impl;

import cn.exam.dao.mapper.zj.ZjPaperInfoMapper;
import cn.exam.dao.mapper.zj.ZjSubjectUserLinkMapper;
import cn.exam.dao.mapper.zj.ZjTitleInfoMapper;
import cn.exam.domain.zj.ZjPaperInfo;
import cn.exam.domain.zj.ZjPaperTest;
import cn.exam.domain.zj.ZjSubjectUserLink;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.PaperQuery;
import cn.exam.query.TitlePageQuery;
import cn.exam.service.ExaminationService;
import cn.exam.util.*;
import cn.exam.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:04
 */
@Service
@Transactional
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ZjTitleInfoMapper  titleInfoMapper;
    @Autowired
    private ZjPaperInfoMapper paperInfoMapper;
    @Autowired
    private ZjSubjectUserLinkMapper userLinkMapper;


    @Override
    public PageResult<List<PaperPageVO>> queryPage(PaperQuery query) {
        return PageUtil.execute(()->paperInfoMapper.queryPage(query),query);
    }

    @Override
    public PageResult<List<TitleVO>> queryPage(TitlePageQuery query) {
        return PageUtil.execute(()->titleInfoMapper.queryPage(query),query);
    }

    @Override
    public void insertTitle(ZjTitleInfo info, UserVO user) {
        String currentDateTime = DateUtil.getCurrentDateTime();
        info.setUserId(user.getUserId());
        info.setUserName(user.getUserName());
        info.setCreateTime(currentDateTime);
        info.setUpdateTime(currentDateTime);
        titleInfoMapper.insertSelective(info);
    }

    @Override
    public TitleVO queryTitleInfo(Integer titleId) {
        if (titleId==null){
            throw  new ExpressException(SystemCode.SERVICE_FAILD_CODE,"题目id为空");
        }
        return titleInfoMapper.queryTitleInfo(titleId);
    }

    @Override
    public void deleteTitle(Integer titleId) {
        if (titleId==null){
            throw  new ExpressException(SystemCode.SERVICE_FAILD_CODE,"题目id为空");
        }
        titleInfoMapper.deleteByPrimaryKey(titleId);
    }

    @Override
    public void updateTitle(ZjTitleInfo info) {
        String currentDateTime = DateUtil.getCurrentDateTime();
        info.setUpdateTime(currentDateTime);
        titleInfoMapper.updateByPrimaryKeySelective(info);
    }

    @Override
    public List<ExamPaperVO> queryPaper(Integer paperId) {
        //1 级
        List<ExamPaperVO> paperVOList = new ArrayList<>();


        List<PaperTitleVO> paperTitleVOS = paperInfoMapper.queryTitlePaper(paperId);
        //分析试卷
        List<PaperTitleVO> collect = paperTitleVOS.stream().filter(f -> f.getTitleStatus() == 0).collect(Collectors.toList());
        List<PaperTitleVO> collect1 = paperTitleVOS.stream().filter(f -> f.getTitleStatus() == 1).collect(Collectors.toList());
        List<PaperTitleVO> collect2 = paperTitleVOS.stream().filter(f -> f.getTitleStatus() == 2).collect(Collectors.toList());
        //单选题总分数
        int result=0;
        if (!ObjectUtils.isEmpty(collect)){
            ExamPaperVO paperVO = new ExamPaperVO();
            result = collect.stream().mapToInt(PaperTitleVO::getFraction).sum();
            paperVO.setFraction(result);
            paperVO.setTitle("单选题");
            paperVO.setId(11);
            paperVO.setType(1);
            List<PaperVO> list = new ArrayList<>();
            for (PaperTitleVO titleVO : collect){
                //二级
                PaperVO paperVO1 = new PaperVO();
                paperVO1.setFraction(titleVO.getFraction());
                paperVO1.setTitle(titleVO.getTitleName());
                paperVO1.setValue(titleVO.getTitleAnswer());
                //三级
                List<AnswerVO> item = new ArrayList<>();
                String data[] = {"A", "B", "C", "D"};
                for (int i=0 ;i<data.length ;i++){
                    AnswerVO answerVO = new AnswerVO();
                    answerVO.setLabel(data[i]);
                    answerVO.setValue(titleVO.getChoice1());
                    item.add(answerVO);
                }
                paperVO1.setItem(item);
                list.add(paperVO1);
            }
            paperVO.setList(list);
            paperVOList.add(paperVO);
        }
        //填空
        if (!ObjectUtils.isEmpty(collect1)){
            int  result1 = collect1.stream().mapToInt(PaperTitleVO::getFraction).sum();
            ExamPaperVO paperVO = new ExamPaperVO();
            paperVO.setFraction(result1);
            paperVO.setTitle("填空");
            paperVO.setId(12);
            paperVO.setType(2);
            List<PaperVO> list = new ArrayList<>();
            for (PaperTitleVO titleVO : collect1){
                //二级
                PaperVO paperVO1 = new PaperVO();
                paperVO1.setFraction(titleVO.getFraction());
                paperVO1.setTitle(titleVO.getTitleName());
//                paperVO1.setValue(titleVO.getTitleAnswer());
                //三级
                List<AnswerVO> item = new ArrayList<>();
                String data[] = {"A", "B", "C", "D"};
                for (int i=0 ;i<data.length ;i++){
                    AnswerVO answerVO = new AnswerVO();
                    answerVO.setLabel(data[i]);
                    answerVO.setValue(titleVO.getChoice1());
                    item.add(answerVO);
                }
                paperVO1.setItem(item);
                list.add(paperVO1);
            }
            paperVO.setList(list);
            paperVOList.add(paperVO);
        }
        //主观
        if (!ObjectUtils.isEmpty(collect2)){
            int result2 = collect2.stream().mapToInt(PaperTitleVO::getFraction).sum();
            ExamPaperVO paperVO = new ExamPaperVO();
            paperVO.setFraction(result2);
            paperVO.setTitle("主观");
            paperVO.setId(13);
            paperVO.setType(3);
            List<PaperVO> list = new ArrayList<>();

            for (PaperTitleVO titleVO : collect2){
                //二级
                PaperVO paperVO1 = new PaperVO();
                paperVO1.setFraction(titleVO.getFraction());
                paperVO1.setTitle(titleVO.getTitleName());
                paperVO1.setValue(titleVO.getTitleAnswer());
//                //三级
//                List<AnswerVO> item = new ArrayList<>();
//                String data[] = {"A", "B", "C", "D"};
//                for (int i=0 ;i<data.length ;i++){
//                    AnswerVO answerVO = new AnswerVO();
//                    answerVO.setLabel(data[i]);
//                    answerVO.setValue(titleVO.getChoice1());
//                    item.add(answerVO);
//                }
//                paperVO1.setItem(item);
                list.add(paperVO1);
            }
            paperVO.setList(list);
            paperVOList.add(paperVO);
        }
        return paperVOList;
    }

    @Override
    public void audioPaper(ZjPaperInfo paperInfo) {
        String currentDateTime = DateUtil.getCurrentDateTime();

        List<ZjTitleInfo> zjTitleInfos = titleInfoMapper.queryTitleByClassId(paperInfo.getClassId());
        if (zjTitleInfos.size()<paperInfo.getPaperNum()){
            throw new ExpressException(SystemCode.SERVICE_FAILD_CODE,"该班级试题不够");
        }

        List<ZjTitleInfo> zjTitleInfos1 = titleInfoMapper.queryTitleByDifficulty(paperInfo.getDifficulty() - 2, paperInfo.getDifficulty() + 2,paperInfo.getClassId());
        if (zjTitleInfos1.size()<paperInfo.getPaperNum()){
            throw new ExpressException(SystemCode.SERVICE_FAILD_CODE,"该班级该难度的试题不够");
        }

        paperInfo.setCreateTime(currentDateTime);
        paperInfo.setUpdateTime(currentDateTime);
        paperInfoMapper.insertSelective(paperInfo);
        zjTitleInfos1.forEach(f->{
            ZjSubjectUserLink userLink = new ZjSubjectUserLink();
            userLink.setClassId(paperInfo.getClassId());
            userLink.setPaperId(paperInfo.getPaperId());
            userLink.setTitleId(f.getTitleId());
            userLink.setCreateTime(currentDateTime);
            userLink.setUpdateTime(currentDateTime);
            userLinkMapper.insertSelective(userLink);
        });
//        List<ZjSubjectUserLink> zjSubjectUserLinks = userLinkMapper.queryByList(paperInfo.getPaperId());
//        List<Integer> titleIdList = new ArrayList<>();
//        if (!ObjectUtils.isEmpty(zjSubjectUserLinks)){
//            zjSubjectUserLinks.forEach(f->{
//                titleIdList.add(f.getTitleId());
//            });
//        }
//
//        ZjSubjectUserLink userLink = zjSubjectUserLinks.get(0);
//        List<ZjTitleInfo> zjTitleInfos2 = titleInfoMapper.queryListByTitleId(titleIdList);
//        List<ZjPaperTest> paperTests = new ArrayList<>();
//        zjTitleInfos2.forEach(f->{
//            ZjPaperTest paperTest = new ZjPaperTest();
//            paperTest.setTitleAnswer(f.getTitleAnswer());
//            paperTest.setClassId(userLink.getClassId());
//            paperTest.setPaperId(paperInfo.getPaperId());
//            paperTest.setTitleFraction(f.getTitleFraction());
//            paperTest.setTitleId(f.getTitleId());
//            paperTest.setUserId(user.getUserId());
//            paperTest.setUserName(user.getUserName());
//            paperTest.setCreateTime(DateUtil.getCurrentDateTime());
//            paperTests.add(paperTest);
//        });
//        paperTestMapper.insertList(paperTests);





    }
}
