package com.shopping.micro.goods.configuration.interceptor;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shopping.micro.goods.constants.ShopExceptionCode;
import com.shopping.micro.goods.entity.User;
import com.shopping.micro.goods.exception.MyShopException;
import com.shopping.micro.goods.service.GoodsService;
import com.shopping.micro.goods.utils.EncryptUtils;
import com.shopping.micro.goods.utils.ResponseUtils;
import com.shopping.micro.goods.utils.ThreadLocalUtils;
import com.shopping.micro.goods.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class MyInterceptor implements HandlerInterceptor {

    private static final Logger LOG = LoggerFactory.getLogger(MyInterceptor.class);

    @Autowired
    GoodsService goodsService;

    /*{
        content-type:application/json,
        serviceId:username,
        signInfo: sha5加密(username + password(MD5加密转大写) + ts)
        ts:当前请求的时间戳（毫秒）
    }*/
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        try {
            String serviceId = request.getHeader("serviceId").trim();
            String signInfo = request.getHeader("signInfo").trim();
            String ts = request.getHeader("ts").trim();
            String reqBody = Util.getReqBodyStrByHeader(request);

            LOG.info("************serviceId************[{}]",serviceId);
            LOG.info("************signInfo*************[{}]",signInfo);
            LOG.info("************reqBody**************[{}]",reqBody);

//          校验签名是否正确
            JSONObject result = goodsService.getCurLoginUser(serviceId);
            LOG.info("************curLoginUser*********[{}]",result.toString());

            JSONObject curJson = result.getJSONObject("data");
            User curUser = JSON.toJavaObject(curJson,User.class);

            String signStr = serviceId + curUser.getPassword() + ts;
            String strEncode = EncryptUtils.shaEncode(signStr);

            LOG.info("************curSignInfo**********[{}]",strEncode);
            if(signInfo.equals(strEncode)){
                ThreadLocalUtils.set(curUser);
                return true;
            } else {
                return errorWrite(response,ShopExceptionCode.SIGNATURE_ERROR);
            }

        } catch (Exception e) {
            e.printStackTrace();
//            response.sendError(500);
            return errorWrite(response,"999999");
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOG.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("afterCompletion");
    }

    /**
     * 错误拦截处理.
     *
     * @param resp      返回对象.
     * @param errorCode 错误码
     * @return false
     * @throws IOException
     * @author BianJiashuai
     * @date 2018年7月6日 下午8:25:16
     */
    private boolean errorWrite(HttpServletResponse resp, String errorCode) throws IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.write(ResponseUtils.failure(errorCode,"签名错误").toString());
        return false;
    }

}
