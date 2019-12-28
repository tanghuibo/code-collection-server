package io.github.tanghuibo.codecollectionserver.config;

import io.github.tanghuibo.codecollectionserver.bean.BizResult;
import io.github.tanghuibo.codecollectionserver.exception.BizException;
import io.github.tanghuibo.codecollectionserver.tools.BizResultBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tanghuibo
 * @date 2019/12/28下午7:30
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            BizException.class
    })
    public BizResult handleBizException(Exception e) {
        e.printStackTrace();
        return BizResultBuilder.buildFailed(e.getMessage());
    }
}
