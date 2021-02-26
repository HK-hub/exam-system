package cn.exam.service.impl;

import cn.exam.dao.mapper.zj.ZjTitleInfoMapper;
import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.TitlePageQuery;
import cn.exam.service.ExaminationService;
import cn.exam.util.PageResult;
import cn.exam.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:04
 */
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Autowired
    private ZjTitleInfoMapper  titleInfoMapper;


    @Override
    public PageResult<List<ZjTitleInfo>> queryPage(TitlePageQuery query) {
        return PageUtil.execute(()->titleInfoMapper.queryPage(query),query);
    }
}
