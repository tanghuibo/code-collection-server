package io.github.tanghuibo.codecollectionserver.bean;

/**
 * @author tanghuibo
 * @date 2019/12/26下午11:37
 */
public class CodeCollectionDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 代码信息
     */
    private FunctionInfoDTO functionInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public FunctionInfoDTO getFunctionInfo() {
        return functionInfo;
    }

    public void setFunctionInfo(FunctionInfoDTO functionInfo) {
        this.functionInfo = functionInfo;
    }
}
