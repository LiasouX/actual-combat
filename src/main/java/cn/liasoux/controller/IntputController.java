package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.Intput;
import cn.liasoux.service.IntputService;
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
public class IntputController {

    @Autowired
    private IntputService service;


    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/intput/findAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Layui findAll(@RequestParam(defaultValue = "1")int page,
                         @RequestParam(value = "limit",defaultValue = "10") int size,
                         @RequestParam(defaultValue = "")String material,
                         @RequestParam(defaultValue = "")String category){
        PageHelper.startPage(page,size);
        List<Intput> intputs = service.findAll(material, category);
        PageInfo info = new PageInfo(intputs);
        Layui layui = Layui.data(info.getTotal(), info.getList());
        return layui;
    }

    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    @RequestMapping("/intput/addIntput")
    @ResponseBody
    public boolean addIntput(Intput intput){
        boolean flag = false;
        try {
            flag = service.addIntput(intput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更新入库信息
     * @param intput
     * @param mate
     * @param quan
     * @param name
     * @return
     */
    @RequestMapping("/intput/updateIntput")
    @ResponseBody
    public boolean updateIntput(Intput intput, String mate, String quan, String name){
        boolean flag = false;
        try {
            flag = service.updateIntput(intput, mate, quan, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 删除库存
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping("/intput/delIntput")
    @ResponseBody
    public boolean delIntput(String mate, String quan, String name){
         boolean flag = false;
         try {
            flag = service.delInput(mate, quan, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
         return flag;
    }

    @RequestMapping(value = "/intput/findByIntput",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByIntput(String mate, String quan, String name) throws Exception {
        Intput byIntput = service.findByIntput(mate, quan, name);
        return JSON.toJSONString(byIntput);
    }


    @RequestMapping("/intput/tpUpdateHtml")
    public String tpUpdateHtml(String mate, String quan, String name){
        return "forward:/views/output/intput/updateIntput.html";
    }


}
