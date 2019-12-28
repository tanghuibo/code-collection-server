package io.github.tanghuibo.codecollectionserver.service.impl;

import com.alibaba.fastjson.JSON;
import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDO;
import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDTO;
import io.github.tanghuibo.codecollectionserver.dao.CodeCollectionDao;
import io.github.tanghuibo.codecollectionserver.exception.BizException;
import io.github.tanghuibo.codecollectionserver.service.CodeCollectionService;
import io.github.tanghuibo.codecollectionserver.tools.CodeCollectionConvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2019/12/28下午4:58
 */
@Service
public class CodeCollectionServiceImpl implements CodeCollectionService {

    @Resource
    CodeCollectionDao codeCollectionDao;

    @Override
    public List<CodeCollectionDTO> getAll() {
        return CodeCollectionConvert.dOToDTOList(codeCollectionDao.selectAll());
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void uploadAll(List<CodeCollectionDTO> codeCollectionDTOS) {
        codeCollectionDao.deleteAll();
        codeCollectionDao.insertList(CodeCollectionConvert.dTOToDOList(codeCollectionDTOS));
    }

    @Override
    public boolean updateById(CodeCollectionDTO codeCollectionDTO) {
        CodeCollectionDO codeCollectionDO = CodeCollectionConvert.dTOToDO(codeCollectionDTO);
        checkExist(codeCollectionDO);
        int result = codeCollectionDao.updateById(codeCollectionDO);
        return result >= 0;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean addOne(CodeCollectionDTO codeCollectionDTO) {
        CodeCollectionDO codeCollectionDO = CodeCollectionConvert.dTOToDO(codeCollectionDTO);
        checkExist(codeCollectionDO);
        int result = codeCollectionDao.insert(codeCollectionDO);
        return result > 0;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        codeCollectionDao.deleteByIds(ids);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public List<CodeCollectionDTO> upload(List<CodeCollectionDTO> codeCollectionDTOS) {
        List<CodeCollectionDO> codeCollectionDOS = CodeCollectionConvert.dTOToDOList(codeCollectionDTOS);
        List<CodeCollectionDO> existCodeCollectionDOS = codeCollectionDao.selectByNames(codeCollectionDOS.stream().map(CodeCollectionDO::getName).collect(Collectors.toList()));;
        List<CodeCollectionDO> needMergeList = new ArrayList<>();
        out: for (CodeCollectionDO codeCollectionDO: codeCollectionDOS) {
            for (CodeCollectionDO existCodeCollectionDO: existCodeCollectionDOS) {
                if(Objects.equals(codeCollectionDO.getName(), existCodeCollectionDO.getName())) {
                    codeCollectionDO.setId(null);
                    existCodeCollectionDO.setId(null);
                    if (Objects.equals(JSON.toJSONString(codeCollectionDO), JSON.toJSONString(existCodeCollectionDO))) {
                        continue out;
                    } else {
                        needMergeList.add(codeCollectionDO);
                        continue out;
                    }
                }
            }
            codeCollectionDao.insert(codeCollectionDO);
        }
        return CodeCollectionConvert.dOToDTOList(needMergeList);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public boolean uploadForced(List<CodeCollectionDTO> codeCollectionDTOS) {
        List<CodeCollectionDO> codeCollectionDOS = CodeCollectionConvert.dTOToDOList(codeCollectionDTOS);
        codeCollectionDao.deleteByNames(codeCollectionDOS.stream().map(CodeCollectionDO::getName).collect(Collectors.toList()));;
        codeCollectionDao.insertList(codeCollectionDOS);
        return true;
    }

    private void checkExist(CodeCollectionDO oldCodeCollection) {
        CodeCollectionDO result = codeCollectionDao.selectByName(oldCodeCollection.getName());

        if(Objects.isNull(result)) {
            return;
        }
        if(!Objects.equals(oldCodeCollection.getId(), result.getId())) {
            throw new BizException("名称已存在");
        }
    }
}
