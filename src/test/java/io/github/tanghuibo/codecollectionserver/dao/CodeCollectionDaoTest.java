package io.github.tanghuibo.codecollectionserver.dao;

import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.Arrays;
import java.util.List;


/**
 * @author tanghuibo
 * @date 2019/12/27上午12:56
 */
@SpringBootTest
class CodeCollectionDaoTest {

    @Resource
    CodeCollectionDao codeCollectionDao;

    @Test
    public void insertTest() {
        CodeCollectionDO codeCollectionDO = new CodeCollectionDO();
        codeCollectionDO.setName("test");
        codeCollectionDO.setCode("test");
        codeCollectionDO.setDesc("test");
        codeCollectionDao.insertList(Arrays.asList(codeCollectionDO));
        List<CodeCollectionDO> codeCollectionDOS = codeCollectionDao.selectAll();
        assert codeCollectionDOS.size() > 0;
    }

}