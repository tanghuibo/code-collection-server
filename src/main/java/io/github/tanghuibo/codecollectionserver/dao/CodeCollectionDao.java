package io.github.tanghuibo.codecollectionserver.dao;

import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDO;
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
     * @param codeCollectionDOList
     * @return
     */
    int insertList(List<CodeCollectionDO> codeCollectionDOList);

    /**
     * 查询数据
     * @return
     */
    List<CodeCollectionDO> selectAll();

    /**
     * 更新数据
     * @param data
     * @return
     */
    int updateById(CodeCollectionDO data);

    /**
     * 删除全部
     */
    void deleteAll();

    /**
     * 通过名字查询
     * @param name
     * @return
     */
    CodeCollectionDO selectByName(String name);


    /**
     * 新增
     * @param codeCollectionDO
     * @return
     */
    int insert(CodeCollectionDO codeCollectionDO);

    /**
     * 通过id删除
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") List<Long> ids);

    /**
     * 通过名字查询
     * @param names
     * @return
     */
    List<CodeCollectionDO> selectByNames(@Param("names") List<String> names);

    /**
     * 通过名称删除
     * @param names
     */
    void deleteByNames(@Param("names") List<String> names);
}
