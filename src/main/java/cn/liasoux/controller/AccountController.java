package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.account;
import cn.liasoux.service.AccountService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService service;


    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/account/findAll")
    @ResponseBody
    public Layui findAll(@RequestParam(defaultValue = "1")int page,
                         @RequestParam(value = "limit",defaultValue = "10") int size,
                         @RequestParam(defaultValue = "")String material,
                         @RequestParam(defaultValue = "")String category){
        PageHelper.startPage(page,size);
        List<account> accounts = service.findAll(material, category);
        PageInfo info = new PageInfo(accounts);
        Layui layui = Layui.data(info.getTotal(), info.getList());
        for (account account : accounts) {
            System.out.println(account);
        }
        return layui;
    }

    @RequestMapping("/account/updateStatus")
    @ResponseBody
    public boolean updateStatus(String status,String name,String material){
        boolean flag = false;
        try {
            flag = service.updateStatus(status,material,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
