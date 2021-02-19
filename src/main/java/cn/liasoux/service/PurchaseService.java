package cn.liasoux.service;

import cn.liasoux.pojo.Purchase;

import java.util.List;

public interface PurchaseService {
    /**
     * 查询全部信息
     * @return
     */
    List<Purchase> findAll(String category,String material);

    /**
     * 添加采购计划
     * @param purchase
     * @return
     * @throws Exception
     */
    boolean addPurchase(Purchase purchase)throws Exception;


     /**
     *更新采购信息
     * @param purchase
     * @return
     * @throws Exception
     */
    boolean updatepur(Purchase purchase)throws Exception;


    /**
     * 查询库存中是否存在该药品
     * @param material
     * @return
     * @throws Exception
     */
    Purchase findByMaterial(String material,String name,int quantity)throws Exception;

    /**
     * 删除采购信息！
     * @param material
     * @param name
     * @param quantity
     * @return
     * @throws Exception
     */
    boolean delPurchase(String material,String name,int quantity)throws Exception;
}
