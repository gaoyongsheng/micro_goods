package com.shopping.micro.goods.configuration.feign;

import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.goods.configuration.interceptor.MyInterceptor;
import com.shopping.micro.goods.exception.MyShopException;
import feign.*;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

/**
 * @Author ldc
 * @Date 2021/1/6 10:17
 * @Version 1.0
 */

@Configuration
public class FeignConfiguration implements RequestInterceptor, ErrorDecoder {

    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                requestTemplate.header(name, values);
            }
        }
    }


    @Override
    public MyShopException decode(String methodKey, Response response) {
        try {
            // 获取异常信息
            String message = Util.toString(response.body().asReader());
            JSONObject jsonObject = JSONObject.parseObject(message);
            LOG.info("========获取异常信息========" + message); //记录日志
            //直接上抛自定义异常
            return new MyShopException(jsonObject.getInteger("status")+"", jsonObject.getString("message"));
        } catch (Exception ex) {
            return new MyShopException("999999",ex.getMessage());
        }
    }


}