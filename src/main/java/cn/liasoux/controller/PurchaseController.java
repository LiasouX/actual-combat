package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.Purchase;
import cn.liasoux.service.PurchaseService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PurchaseController {
//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//    }

    @Autowired
    private PurchaseService service;

    /**
     * 查询采购物资全部信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/purchase/findAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Layui findAll(@RequestParam(defaultValue = "1") int page,
                         @RequestParam(value = "limit",defaultValue = "10") int size,
                         @RequestParam(defaultValue = "") String category,
                         @RequestParam(defaultValue = "") String material){
        PageHelper.startPage(page,size);
        List<Purchase> purchases = service.findAll(category,material);
        PageInfo info = new PageInfo(purchases);
        Layui layui = Layui.data(info.getTotal(), info.getList());
        return layui;
    }

    @RequestMapping("/purchase/addPurchase")
    @ResponseBody
    public boolean addPurchase(Purchase purchase){
        boolean flag = false;
        try {
            flag = service.addPurchase(purchase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping("/purchase/updatePurchase")
    @ResponseBody
    public boolean updatePurchase(Purchase purchase){
        boolean flag = false;
        try {
            flag = service.updatepur(purchase);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping("/purchase/delPurchase")
    @ResponseBody
    public boolean delPurchase(String material,String name,int quantity){

        boolean flag = false;
        try {
            flag = service.delPurchase(material,name,quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    @RequestMapping(value = "/purchase/findByMaterial",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByMaterial(String material,String name,int quantity){
        Purchase purchase = null;
        try {
            purchase = service.findByMaterial(material,name,quantity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(purchase);
    }
//
    @RequestMapping("/purchase/toUpdatePur")
    public String toUpdatePur(String material,String name,int quantity){
        return "forward:/views/purchase/purchase/updatePur.html";
    }


}
