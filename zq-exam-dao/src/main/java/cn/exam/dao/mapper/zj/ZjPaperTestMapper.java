/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjPaperTest;
import cn.exam.vo.PaperTestVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @File: ZjPaperTest
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjPaperTestMapper
        extends CommonBaseMapper<ZjPaperTest> {

    List<PaperTestVO> queryPaperTest(@Param("userId") String userId,@Param("paperId") Integer paperId);
}
