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

    /**
     * 提交申领
     * @param status
     * @param name
     * @param material
     * @return
     */
    @RequestMapping("/output/updateStatus")
    @ResponseBody
    public boolean updateStatus(String status,String name,String material,int quan){
        boolean flag = false;
        try {
            flag = service.updateStatus(status, name, material,quan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更新
     * @param output
     * @param name
     * @param material
     * @return
     */
    @RequestMapping("/output/updateOutput")
    @ResponseBody
    public boolean updateOutput(Output output,String name,String material){
        boolean flag = false;
        try {
            flag = service.updateOutput(output,material ,name );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 删除
     * @param name
     * @param material
     * @return
     */
    @RequestMapping("/output/delOutput")
    @ResponseBody
    public boolean delOutput(String name,String material){
        boolean flag = false;
        try {
            flag = service.delOutput(material,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 添加
     * @param output
     * @return
     */
    @RequestMapping("/output/addOutput")
    @ResponseBody
    public boolean addOutput(Output output){
        boolean flag = false;
        try {
            flag = service.addOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }


    /**
     * 查找指定
     * @param name
     * @param material
     * @return
     */
    @RequestMapping(value = "/output/findByOutput",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Output findByOutput(String name,String material){
        Output output = null;
        try {
            output = service.findByOutput(material, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }


    @RequestMapping("output/toUpdateHtml")
    public String toUpdateHtml(String name,String material){
        return "forward:/views/output/output/updateIntput.html";
    }

}
