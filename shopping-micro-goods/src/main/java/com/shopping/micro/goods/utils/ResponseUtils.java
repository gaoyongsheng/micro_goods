package com.shopping.micro.goods.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date
 */
public class ResponseUtils {

    private static final Logger LOG = LoggerFactory.getLogger(ResponseUtils.class);

    public static JSONObject success(Object data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","0");
        jsonObject.put("msg","OK");
        if(null == data){
            jsonObject.put("data","");
        } else {
            jsonObject.put("data",data);
        }

        LOG.info("************responseBody**************[{}]",jsonObject.toString());

        return jsonObject;
    }

    public static JSONObject failure(String code, String msg) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",code);
        jsonObject.put("msg",msg);
        jsonObject.put("data","");

        LOG.info("************responseBody**************[{}]",jsonObject.toString());

        return jsonObject;
    }


}
