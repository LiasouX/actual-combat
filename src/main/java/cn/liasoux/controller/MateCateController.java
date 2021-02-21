package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.MateCate;
import cn.liasoux.service.MateCateService;
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
public class MateCateController {

    @Autowired
    private MateCateService service;

    /**
     * 查询全部物资分类信息
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/matecate/findAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Layui findAll(@RequestParam(value = "page",defaultValue = "1") int page,
                         @RequestParam(value = "limit",defaultValue = "10") int size){
        PageHelper.startPage(page,size);
        List<MateCate> mateCates = service.findAll();
        PageInfo info = new PageInfo(mateCates);
        Layui data = Layui.data(info.getTotal(), info.getList());
        return data;
    }

    /**
     * 添加物资分类信息
     * @param mateCate
     * @return
     */
    @RequestMapping(value = "/matecate/addMateCate",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean addMateCate(MateCate mateCate){
        boolean flag =false;
        try {
            flag = service.addMateCate(mateCate);
        } catch (Exception e) {

        }
        return flag;
    }

    /**
     * 删除物资分类信息
     * @param code
     * @return
     */
    @RequestMapping(value = "/matecate/delMateCate",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean delMateCate(String code){
        boolean flag = false;
        try {
            flag = service.delMateCate(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 更新物资分类信息
     * @param cd
     * @param mateCate
     * @return
     */
    @RequestMapping(value = "/matecate/updateMateCate",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean updateMateCate(String cd,MateCate mateCate){
        boolean flag = false;
        try {
            flag = service.updateMateCate(mateCate,cd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 根据分类编号查询出数据
     * @param code
     * @return
     */
    @RequestMapping(value = "/matecate/findByCode",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByCode(String code){
        MateCate mateCate = null;
        try {
            mateCate = service.findByCode(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(mateCate);
    }

    /**
     * 查询
     * @param code
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/matecate/findByCodeBoolean",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean findByCode1(String code) throws Exception {
        boolean flag = false;
        MateCate byCode = service.findByCode(code);
        if (byCode!=null){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    /**
     * 跳转页面updateMC.html
     * @param code
     * @return
     */
    @RequestMapping("/toUpdateMateCate")
    public String toUpdateMateCate(String code){
        return "forward:/views/admin/matecate/updateMC.html";
    }

}
