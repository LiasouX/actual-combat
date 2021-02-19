package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.Output;
import cn.liasoux.service.OutputService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OutputController {

    @Autowired
    private OutputService service;


    /**
     * 查询全部
     * @return
     */
    @RequestMapping(value = "/output/findAll")
    @ResponseBody
    public Layui findAll(@RequestParam(defaultValue = "1")int page,
                         @RequestParam(value = "limit",defaultValue = "10") int size,
                         @RequestParam(defaultValue = "")String material,
                         @RequestParam(defaultValue = "")String category){
        PageHelper.startPage(page,size);
        List<Output> outputs = service.findAll(material, category);
        PageInfo info = new PageInfo(outputs);
        Layui layui = Layui.data(info.getTotal(), info.getList());
        return layui;
    }

    @RequestMapping("/output/updateStatus")
    @ResponseBody
    public boolean updateStatus(String status,String name,String material){
        boolean flag = false;
        try {
            flag = service.updateStatus(status, name, material);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
