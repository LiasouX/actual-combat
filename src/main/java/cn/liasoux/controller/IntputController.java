package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.Intput;
import cn.liasoux.service.IntputService;
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
        for (Intput intput : intputs) {
            System.out.println(intput);
        }
        return layui;
    }
}
