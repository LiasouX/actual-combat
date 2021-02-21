package cn.liasoux.service;

import cn.liasoux.pojo.Intput;
import cn.liasoux.pojo.wuzi;

import java.util.List;


public interface IntputService {

    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    List<Intput> findAll(String name,String mata);




    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    boolean addIntput(Intput intput)throws Exception;


    /**
     * 更新入库信息
     * @param intput
     * @param mate
     * @param quan
     * @param name
     * @return
     */
    boolean updateIntput(Intput intput, String mate, String quan, String name)throws Exception;


    /**
     * 删除库存
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    boolean delInput(String mate, String quan, String name)throws Exception;


    /**
     * 查询指定intput信息
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    Intput findByIntput(String mate,String quan, String name)throws Exception;


    /**
     * 查询物资数量
     * @return
     */
    wuzi findPurchase();
}
