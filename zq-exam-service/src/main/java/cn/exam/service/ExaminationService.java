package cn.exam.service;

import cn.exam.domain.zj.ZjTitleInfo;
import cn.exam.query.TitlePageQuery;
import cn.exam.util.PageResult;
import cn.exam.util.PageUtil;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-02-26 14:03
 */
public interface ExaminationService {


    PageResult<List<ZjTitleInfo>> queryPage(TitlePageQuery query);
}
