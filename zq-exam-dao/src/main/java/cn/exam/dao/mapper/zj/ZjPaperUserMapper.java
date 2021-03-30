/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjPaperUser;
import cn.exam.query.PaperUserQuery;
import cn.exam.vo.PaperUserPapage;

import java.util.List;


/**
 * @File: ZjPaperUser
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjPaperUserMapper
        extends CommonBaseMapper<ZjPaperUser> {


    ZjPaperUser queryPaper(ZjPaperUser paperUser);

    List<PaperUserPapage> queryPage(PaperUserQuery query);

}
