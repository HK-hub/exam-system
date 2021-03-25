package cn.exam.service.impl;

import cn.exam.dao.mapper.zj.ZjPaperTestMapper;
import cn.exam.service.PaperTestService;
import cn.exam.vo.PaperTestLevel;
import cn.exam.vo.PaperTestVO;
import cn.exam.vo.PaperTitleVO;
import cn.exam.vo.TestLevelOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-19 13:37
 */
@Service
public class PaperTestServiceImpl implements PaperTestService {
    @Autowired
    private ZjPaperTestMapper paperTestMapper;


    @Override
    public PaperTestLevel paperTest(Integer paperId, String userId) {
        PaperTestLevel testLevel = new PaperTestLevel();
        List<PaperTestVO> paperTestVOS = paperTestMapper.queryPaperTest(userId, paperId);
        PaperTestVO paperTestVO = paperTestVOS.get(0);
        //分析试卷
        List<PaperTestVO> collect = paperTestVOS.stream().filter(f -> f.getTitleStatus() == 0).collect(Collectors.toList());
        List<PaperTestVO> collect1 = paperTestVOS.stream().filter(f -> f.getTitleStatus() == 1).collect(Collectors.toList());
        List<PaperTestVO> collect2 = paperTestVOS.stream().filter(f -> f.getTitleStatus() == 2).collect(Collectors.toList());
        //所有题目总分
        int sum3 = paperTestVOS.stream().mapToInt(PaperTestVO::getTitleFraction).sum();
        //单选题总分
        int sum = collect.stream().mapToInt(PaperTestVO::getTitleFraction).sum();
        //填空题总分
        int sum1 = collect1.stream().mapToInt(PaperTestVO::getTitleFraction).sum();
        //主观题总分
        int sum2 = collect2.stream().mapToInt(PaperTestVO::getTitleFraction).sum();
        testLevel.setExamDate(paperTestVO.getExamDate());
        testLevel.setPaperName(paperTestVO.getPaperName());
        testLevel.setUserName(paperTestVO.getUserName());
        testLevel.setTotalScore(sum3);
        testLevel.setFractionSum(sum);
        testLevel.setFractionSum1(sum1);
        testLevel.setFractionSum2(sum2);
        testLevel.setTitleNum(collect.size());
        testLevel.setTitleNum1(collect1.size());
        testLevel.setTitleNum2(collect2.size());
        List<TestLevelOne> oneList1 = new ArrayList<>();
        List<TestLevelOne> oneList2 =new ArrayList<>();
        List<TestLevelOne> oneList3 = new ArrayList<>();
        paperTestVOS.forEach(f->{
            //单选
            if (f.getTitleStatus()==0){
                TestLevelOne levelOne = new TestLevelOne();
                levelOne.setTitleName(f.getTitleName());
                levelOne.setTitleFraction(f.getTitleFraction());
                levelOne.setChoice1(f.getChoice1());
                levelOne.setChoice2(f.getChoice2());
                levelOne.setChoice3(f.getChoice3());
                levelOne.setChoice4(f.getChoice4());
                levelOne.setId(f.getId());
                oneList1.add(levelOne);
            }else if(f.getTitleStatus()==1){
                TestLevelOne levelOne = new TestLevelOne();
                levelOne.setTitleName(f.getTitleName());
                levelOne.setTitleFraction(f.getTitleFraction());
                levelOne.setId(f.getId());
                oneList2.add(levelOne);
            }else if (f.getTitleStatus()==2){
                TestLevelOne levelOne = new TestLevelOne();
                levelOne.setTitleName(f.getTitleName());
                levelOne.setId(f.getId());
                levelOne.setTitleFraction(f.getTitleFraction());
                oneList3.add(levelOne);
            }
        });
        testLevel.setOneList1(oneList1);
        testLevel.setOneList2(oneList2);
        testLevel.setOneList3(oneList3);
        return testLevel;
    }
}
