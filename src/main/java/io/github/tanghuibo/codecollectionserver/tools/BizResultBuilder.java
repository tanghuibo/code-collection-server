package io.github.tanghuibo.codecollectionserver.tools;


import io.github.tanghuibo.codecollectionserver.bean.BizResult;

/**
 * @author tanghuibo
 * @date 2019/12/21下午7:40
 */
public class BizResultBuilder {

    /**
     * 创建成功结果
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> buildSuccess(T data) {
        return new BizResult<>(true, null, data);
    }

    /**
     * 创建成功结果
     * @param
     * @param <T>
     * @return
     */
    public static <T> BizResult<T> buildSuccess() {
        return new BizResult<>(true, null, null);
    }

    /**
     * 创建失败结果
     * @param message
     * @return
     */
    public static BizResult buildFailed(String message) {
        return new BizResult<>(false, message, null);
    }
}
