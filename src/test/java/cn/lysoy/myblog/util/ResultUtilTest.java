package cn.lysoy.myblog.util;

import cn.lysoy.myblog.common.constant.CodeEnum;
import cn.lysoy.myblog.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class ResultUtilTest {
    @Test
    public static void main(String[] args) {
        System.out.println(ResultUtil.success("1"));
        System.out.println(ResultUtil.success(1, CodeEnum.SUCCESS_STATUS, "2"));
        System.out.println(ResultUtil.success(1, "3"));
        System.out.println(ResultUtil.error(CodeEnum.SUCCESS_STATUS.getCode(), CodeEnum.SUCCESS_STATUS.getMessage()));
        Result<String> result = ResultUtil.success(1, CodeEnum.SUCCESS_STATUS, "2");
        result.setData("1");
        System.out.println(result.getMsg()+" "+result.getCode()+" "+result.getData().toString()+" "+result);
    }
}
