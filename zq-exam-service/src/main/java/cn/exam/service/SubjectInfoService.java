package cn.exam.service;

import cn.exam.domain.zj.ZjSubjectInfo;
import cn.exam.query.SubjectQuery;
import cn.exam.util.PageResult;

import java.util.List;

/**
 * @author YS
 * @version 1.0
 * @date 2021-03-02 18:10
 */
public interface SubjectInfoService {

    void  insertSubject(ZjSubjectInfo info);

    void  updateSubject(ZjSubjectInfo info);

    void delete(ZjSubjectInfo info);

    PageResult<List<ZjSubjectInfo>> queryPageBySubject(SubjectQuery query);

    List<ZjSubjectInfo> queryList();

}
