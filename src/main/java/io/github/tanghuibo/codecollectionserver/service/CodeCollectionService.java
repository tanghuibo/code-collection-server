package io.github.tanghuibo.codecollectionserver.service;

import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDTO;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2019/12/28下午4:57
 */
public interface CodeCollectionService {

    /**
     * 获取全部
     * @return
     */
    List<CodeCollectionDTO> getAll();

    /**
     * 全量导入
     * @param codeCollectionDTOS
     * @return
     */
    void uploadAll(List<CodeCollectionDTO> codeCollectionDTOS);

    /**
     * 通过id更新数据
     * @param codeCollectionDTO
     * @return
     */
    boolean updateById(CodeCollectionDTO codeCollectionDTO);

    /**
     * 创建
     * @param codeCollectionDTO
     * @return
     */
    boolean addOne(CodeCollectionDTO codeCollectionDTO);

    /**
     * 通过id删除
     * @param ids
     * @return
     */
    boolean deleteByIds(List<Long> ids);

    /**
     * 导入
     * @param codeCollectionDTOS
     * @return
     */
    List<CodeCollectionDTO> upload(List<CodeCollectionDTO> codeCollectionDTOS);

    /**
     * 强力导入(删除已存在的名称)
     * @param codeCollectionDTOS
     * @return
     */
    boolean uploadForced(List<CodeCollectionDTO> codeCollectionDTOS);
}
