package cn.lysoy.myblog.util;

import cn.lysoy.myblog.entity.User;
import cn.lysoy.myblog.model.DataMap;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import cn.lysoy.myblog.common.constant.CodeEnum;

import java.util.LinkedHashMap;

/**
 * @author: LySoY
 * @Date: 2022/2/14
 * Describe: 控制层Json数据处理
 */
public class JsonUtil {

    /**
     * 参照Unix命令行返回值 0代表成功，大于0代表不同的错误
     */
    private static final int DEFAULT_STATUS_SUCCESS = 0;
    private static final int DEFAULT_STATUS_FAIL = 1;

    private static final String DEFAULT_STATUS_KEY = "status";
    private static final String DEFAULT_MESSAGE_KEY = "message";
    private static final String DEFAULT_DATA_KEY = "data";

    private JsonUtil() {
    }

    public static JsonData success() {
        return build(DEFAULT_STATUS_KEY, DEFAULT_STATUS_SUCCESS);
    }

    public static JsonData success(Object code) {
        return build(DEFAULT_STATUS_KEY, code);
    }

    public static JsonData success(String codeKey, Object code) {
        return build(codeKey, code);
    }


    public static JsonData fail() {
        return build(DEFAULT_STATUS_KEY, DEFAULT_STATUS_FAIL);
    }

    public static JsonData fail(Object code) {
        return build(DEFAULT_STATUS_KEY, code);
    }

    public static JsonData fail(String codeKey, Object code) {
        return build(codeKey, code);
    }

    private static JsonData build(String key, Object value) {
        JsonData jsonData = new JsonUtil().new JsonData(3);
        if(value instanceof CodeEnum){
            jsonData.put(key, ((CodeEnum) value).getCode());
            jsonData.put(DEFAULT_MESSAGE_KEY, ((CodeEnum) value).getMessage());
        } else {
            jsonData.put(key, value);
        }

        return jsonData;
    }

    public static JsonData build() {
        return new JsonUtil().new JsonData();
    }

    public static JsonData build(DataMap dataMap) {
        JsonData jsonData = new JsonUtil().new JsonData(3);
        if (dataMap.getCode() != null) {
            jsonData.put(DEFAULT_STATUS_KEY, dataMap.getCode());
        } else {
            if (dataMap.getSuccess() != null) {
                if (dataMap.getSuccess()) {
                    jsonData.put(DEFAULT_STATUS_KEY, DEFAULT_STATUS_SUCCESS);
                } else {
                    jsonData.put(DEFAULT_STATUS_KEY, DEFAULT_STATUS_FAIL);
                }
            }
        }
        if (dataMap.getMessage() != null) {
            jsonData.put(DEFAULT_MESSAGE_KEY, dataMap.getMessage());
        }
        if (dataMap.getData() != null) {
            jsonData.put(DEFAULT_DATA_KEY, dataMap.getData());
        }
        return jsonData;
    }

    public static String toJson(Object object) {
        return JSONUtils.toJSONString(object);
    }

    public class JsonData extends LinkedHashMap {

        private static final long serialVersionUID = 1L;

        private JsonData() {
        }

        private JsonData(int size) {
            super(size);
        }

        public JsonData message(String messageKey, String message) {
            this.put(messageKey, message);
            return this;
        }

        public JsonData message(String message) {
            return message(DEFAULT_MESSAGE_KEY, message);
        }

        public JsonData data(String dataKey, Object data) {
            this.put(dataKey, data);
            return this;
        }

        public JsonData data(Object data) {
            return data(DEFAULT_DATA_KEY, data);
        }

        public JsonData add(String key, Object value) {
            this.put(key, value);
            return this;
        }

        public String toJSON() {
            return JSON.toJSONString(this);
        }
    }

}
