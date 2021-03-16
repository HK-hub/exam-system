/**
 * 	Copyright 2020 www.zj.cn
 *
 * 	All right reserved
 *
 * 	Create on 2020/5/20 05:20
 */
package cn.exam.dao.mapper.zj;

import cn.exam.dao.mapper.base.CommonBaseMapper;
import cn.exam.domain.zj.ZjSubjectInfo;
import cn.exam.query.SubjectQuery;

import java.util.List;


/**
 * @File: ZjSubjectInfo
 * @Author: ys
 * @Date: 2020/5/20 05:20
 * @Description:
 */
public interface ZjSubjectInfoMapper
        extends CommonBaseMapper<ZjSubjectInfo> {

    List<ZjSubjectInfo> queryPageBySubject(SubjectQuery query);


}
