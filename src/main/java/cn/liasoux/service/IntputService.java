package cn.liasoux.service;

import cn.liasoux.pojo.Intput;

import java.util.List;


public interface IntputService {

    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    List<Intput> findAll(String name,String mata);
}
