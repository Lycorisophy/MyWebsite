package cn.lysoy.myblog.model;

import lombok.Data;

/**
 * @author: LySoY
 * @Date: 2022/2/13
 * Describe: 返回统一的响应格式
 */
@Data
public class Result<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private  T data;

    /**
     * 创建时间
     */
    private static final long time = System.currentTimeMillis();
}
