package com.shopping.micro.goods.entity.base;

import java.io.Serializable;

public interface ToDto<T> extends Serializable {
    T toDto();
}
