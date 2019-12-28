package io.github.tanghuibo.codecollectionserver.bean;

import java.util.List;
import java.util.Map;

/**
 * @author tanghuibo
 * @date 2019/12/28下午6:17
 */
public class FunctionInfoDTO {

    /**
     * 参数列表
     */
    private List<Map<String, Object>> params;

    /**
     * 函数体
     */
    private String printFunction;

    public String getPrintFunction() {
        return printFunction;
    }

    public void setPrintFunction(String printFunction) {
        this.printFunction = printFunction;
    }

    public List<Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(List<Map<String, Object>> params) {
        this.params = params;
    }
}
