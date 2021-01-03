package com.shopping.micro.goods.service;

import com.shopping.micro.goods.vo.MailVo;

/**
 * @Author Gao
 * @Date 2020/12/25 23:52
 * @Version 1.0
 */
public interface MailService {

    MailVo sendMail(MailVo mailVo);
}
