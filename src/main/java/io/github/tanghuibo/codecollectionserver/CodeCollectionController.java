package io.github.tanghuibo.codecollectionserver;

import io.github.tanghuibo.codecollectionserver.bean.BizResult;
import io.github.tanghuibo.codecollectionserver.bean.CodeCollectionDTO;
import io.github.tanghuibo.codecollectionserver.service.CodeCollectionService;
import io.github.tanghuibo.codecollectionserver.tools.BizResultBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author tanghuibo
 * @date 2019/12/28下午4:58
 */
@RestController
@RequestMapping("codeCollection")
public class CodeCollectionController {

    @Resource
    CodeCollectionService codeCollectionService;

    @GetMapping("getAll")
    BizResult<List<CodeCollectionDTO>> getAll() {
        return BizResultBuilder.buildSuccess(codeCollectionService.getAll());
    }

    @PostMapping("uploadAll")
    BizResult<Void> uploadAll(@RequestBody List<CodeCollectionDTO> codeCollectionDTOS) {
        codeCollectionService.uploadAll(codeCollectionDTOS);
        return BizResultBuilder.buildSuccess();
    }

    @PostMapping("upload")
    BizResult<List<CodeCollectionDTO>> upload(@RequestBody List<CodeCollectionDTO> codeCollectionDTOS) {
        List<CodeCollectionDTO> list = codeCollectionService.upload(codeCollectionDTOS);
        return BizResultBuilder.buildSuccess(list);
    }

    @PostMapping("uploadForced")
    BizResult<List<CodeCollectionDTO>> uploadForced(@RequestBody List<CodeCollectionDTO> codeCollectionDTOS) {
        codeCollectionService.uploadForced(codeCollectionDTOS);
        return BizResultBuilder.buildSuccess();
    }

    @PostMapping("addOne")
    BizResult<Void> addOne(@RequestBody CodeCollectionDTO codeCollectionDTO) {
        if(codeCollectionService.addOne(codeCollectionDTO)) {
            return BizResultBuilder.buildSuccess();
        }
        return BizResultBuilder.buildFailed("创建失败");
    }

    @PostMapping("updateById")
    BizResult<Object> updateById(@RequestBody CodeCollectionDTO codeCollectionDTO) {
        if(codeCollectionService.updateById(codeCollectionDTO)) {
            return BizResultBuilder.buildSuccess();
        }
        return BizResultBuilder.buildFailed("更新失败");
    }

    @PostMapping("deleteByIds")
    BizResult<Object> updateByIds(@RequestBody List<Long> ids) {
        if(codeCollectionService.deleteByIds(ids)) {
            return BizResultBuilder.buildSuccess();
        }
        return BizResultBuilder.buildFailed("删除失败");
    }
}
