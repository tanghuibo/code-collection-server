package io.github.tanghuibo.codecollectionserver.dao;

import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionBean;
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
        CodeCollectionBean codeCollectionBean = new CodeCollectionBean();
        codeCollectionBean.setName("test");
        codeCollectionBean.setCode("test");
        codeCollectionBean.setDesc("test");
        codeCollectionDao.insertList(Arrays.asList(codeCollectionBean));
        List<CodeCollectionBean> codeCollectionBeans = codeCollectionDao.selectAll();
        assert codeCollectionBeans.size() > 0;
    }

}