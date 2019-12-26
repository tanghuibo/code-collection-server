package io.github.tanghuibo.codecollectionserver.dao;

import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2019/12/26下午11:36
 */
@Mapper
public interface CodeCollectionDao {

    /**
     * 插入数据
     * @param codeCollectionBeanList
     * @return
     */
    int insertList(List<CodeCollectionBean> codeCollectionBeanList);

    /**
     * 查询数据
     * @return
     */
    List<CodeCollectionBean> selectAll();

    /**
     * 更新数据
     * @param data
     * @param id
     * @return
     */
    int updateById(@Param("data") CodeCollectionBean data,@Param("id") Long id);

}
