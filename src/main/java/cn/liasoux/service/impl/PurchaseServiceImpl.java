package cn.liasoux.service.impl;

import cn.liasoux.mapper.PurchaseMapper;
import cn.liasoux.pojo.Purchase;
import cn.liasoux.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseMapper mapper;

    /**
     * 查询全部信息
     * @return
     */
    @Override
    public List<Purchase> findAll(String category,String material){
        List<Purchase> purchase = null;
        if ("".equals(category)){
            purchase = mapper.findAll("%"+material+"%");
        }else{
            purchase = mapper.findAllCate(category,"%"+material+"%");
        }
       return purchase;
    }

    /**
     * 添加采购计划
     * @param purchase
     * @return
     * @throws Exception
     */
    @Override
    public boolean addPurchase(Purchase purchase) throws Exception {

        return mapper.addPurchase(purchase);
    }


    /**
     *更新采购信息
     * @param purchase
     * @return
     * @throws Exception
     */
    @Override
    public boolean updatepur(Purchase purchase) throws Exception {
        return mapper.updatepur(purchase);
    }

    /**
     * 查询库存中是否存在该药品
     * @param material
     * @return
     * @throws Exception
     */
    @Override
    public Purchase findByMaterial(String material,String name,int quantity) throws Exception {
        return mapper.findByMaterial(material,name,quantity);
    }

    /**
     * 删除采购信息！
     * @param material
     * @param name
     * @param quantity
     * @return
     * @throws Exception
     */
    @Override
    public boolean delPurchase(String material,String name,int quantity) throws Exception {

        return mapper.delPurchase(material,name,quantity);
    }


}
