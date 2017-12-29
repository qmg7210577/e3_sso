package com.e3mall.sso.service.impl;

import com.e3mall.mapper.TbUserMapper;
import com.e3mall.pojo.TbUser;
import com.e3mall.pojo.TbUserExample;
import com.e3mall.sso.service.RegisterService;
import com.e3mall.utils.E3Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qimenggao on 2017/12/29.
 */
public class RegisterServiceImpl implements RegisterService{
    @Autowired
    private TbUserMapper userMapper;

    @Override
    public E3Result checkData(String param, Integer type) {
        // 1、从tb_user表中查询数据
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        // 2、查询条件根据参数动态生成。
        //1、2、3分别代表username、phone、email
        if (type == 1) {
            criteria.andUsernameEqualTo(param);
        } else if (type == 2) {
            criteria.andPhoneEqualTo(param);
        } else if (type == 3) {
            criteria.andEmailEqualTo(param);
        } else {
            return E3Result.build(400, "非法的参数");
        }
        //执行查询
        List<TbUser> list = userMapper.selectByExample(example);
        // 3、判断查询结果，如果查询到数据返回false。
        if (list == null || list.size() == 0) {
            // 4、如果没有返回true。
            return E3Result.ok(true);
        }
        // 5、使用e3Result包装，并返回。
        return E3Result.ok(false);
    }
}
