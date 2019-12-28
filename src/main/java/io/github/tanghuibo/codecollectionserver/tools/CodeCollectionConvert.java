package io.github.tanghuibo.codecollectionserver.tools;

import com.alibaba.fastjson.JSON;
import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDO;
import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDTO;
import io.github.tanghuibo.codecollectionserver.bean.FunctionInfoDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tanghuibo
 * @date 2019/12/28下午6:24
 */
public class CodeCollectionConvert {

    public static CodeCollectionDO dTOToDO(CodeCollectionDTO codeCollectionDTO) {
        CodeCollectionDO codeCollectionDO = new CodeCollectionDO();
        codeCollectionDO.setCode(JSON.toJSONString(codeCollectionDTO.getFunctionInfo()));
        codeCollectionDO.setDesc(codeCollectionDTO.getDesc());
        codeCollectionDO.setName(codeCollectionDTO.getName());
        codeCollectionDO.setId(codeCollectionDTO.getId());
        return codeCollectionDO;
    }

    public static CodeCollectionDTO dOToDTO(CodeCollectionDO codeCollectionDO) {
        CodeCollectionDTO codeCollectionDTO = new CodeCollectionDTO();
        codeCollectionDTO.setDesc(codeCollectionDO.getDesc());
        codeCollectionDTO.setName(codeCollectionDO.getName());
        codeCollectionDTO.setId(codeCollectionDO.getId());
        codeCollectionDTO.setFunctionInfo(JSON.parseObject(codeCollectionDO.getCode(), FunctionInfoDTO.class));
        return codeCollectionDTO;
    }

    public static List<CodeCollectionDO> dTOToDOList(List<CodeCollectionDTO> codeCollectionDTOS) {
        return codeCollectionDTOS.stream().map(CodeCollectionConvert::dTOToDO).collect(Collectors.toList());
    }

    public static List<CodeCollectionDTO> dOToDTOList(List<CodeCollectionDO> codeCollectionDOS) {
        return codeCollectionDOS.stream().map(CodeCollectionConvert::dOToDTO).collect(Collectors.toList());
    }
}
