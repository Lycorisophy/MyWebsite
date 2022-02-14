package cn.lysoy.myblog.util;

import cn.lysoy.myblog.common.constant.CodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
@Slf4j
public class JsonUtilTest {
    @Test
    public static void main(String[] args) {
        System.out.println(JsonUtil.success());
        System.out.println(JsonUtil.success(CodeEnum.CATEGORY_EXIST));
        System.out.println(JsonUtil.success("1", CodeEnum.SUCCESS_STATUS));
        System.out.println(JsonUtil.fail());
        System.out.println(JsonUtil.fail(CodeEnum.CATEGORY_EXIST));
        System.out.println(JsonUtil.fail("1", CodeEnum.SUCCESS_STATUS));
    }
}
