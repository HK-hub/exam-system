/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjSubjectUserLink;

import java.util.List;


/**
 * @File: ZjSubjectUserLink
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjSubjectUserLinkMapper
        extends CommonBaseMapper<ZjSubjectUserLink> {


    List<ZjSubjectUserLink> queryByList(Integer paperId);


}