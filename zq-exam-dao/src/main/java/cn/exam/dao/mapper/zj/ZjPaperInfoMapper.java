/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjPaperInfo;
import cn.exam.query.PaperQuery;
import cn.exam.vo.ExamPaperVO;
import cn.exam.vo.PaperPageVO;
import cn.exam.vo.PaperTitleVO;

import java.util.List;


/**
 * @File: ZjPaperInfo
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjPaperInfoMapper
        extends CommonBaseMapper<ZjPaperInfo> {

    /**
     * 式卷页面
     * @return
     */
    List<PaperPageVO> queryPage(PaperQuery query);


    List<PaperTitleVO> queryTitlePaper(Integer paperId);
}
