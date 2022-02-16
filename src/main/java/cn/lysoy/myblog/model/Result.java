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
     * true 成功
     * false 失败
     */
    private boolean success;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private  T data;
}
