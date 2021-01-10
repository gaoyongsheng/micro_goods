package com.shopping.micro.goods.remote;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

/**
 * @Author Gao
 * @Date 2021/1/10 16:04
 * @Version 1.0
 */

@Component
public class FeignUserFallBack implements FeignUserService {

    @Override
    public JSONObject findUserByUserNameOrMobile(String str) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code","111111");
        jsonObject.put("msg","微服务异常");
        jsonObject.put("data","str");
        return jsonObject;
    }

}
