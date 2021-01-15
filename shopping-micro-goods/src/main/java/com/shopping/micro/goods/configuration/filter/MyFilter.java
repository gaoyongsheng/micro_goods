package com.shopping.micro.goods.configuration.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Slf4j
@Configuration
public class MyFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        MyRequestWrapper myRequestWrapper = new MyRequestWrapper(httpServletRequest);
        filterChain.doFilter(myRequestWrapper,servletResponse);
//        注册过滤器时，ExceptionFilter排序要再其他过滤器之前
//        // 简单实现异常过滤Filter
//        try {
//            filterChain.doFilter(myRequestWrapper,servletResponse);
//        } catch (Exception e) {
//            // 异常捕获，发送到error controller
//            servletRequest.setAttribute("filter.error", e);
//            //将异常分发到/error/exthrow控制器
//            servletRequest.getRequestDispatcher("/error/exthrow").forward(servletRequest, servletResponse);
//        }
    }

    @Override
    public void destroy() {
        log.info("destory");
    }

}
