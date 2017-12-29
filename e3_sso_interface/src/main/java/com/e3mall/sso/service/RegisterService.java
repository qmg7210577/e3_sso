package com.e3mall.sso.service;

import com.e3mall.utils.E3Result;

/**
 * Created by qimenggao on 2017/12/29.
 */
public interface RegisterService {
    E3Result  checkData(String param, Integer type);
}
