package cn.liasoux.controller;

import cn.liasoux.Untils.Layui;
import cn.liasoux.pojo.User;
import cn.liasoux.service.UserService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    @RequestMapping("")
    public String toLogin(){
        return "login";
    }



    @RequestMapping(value = "/user/loginName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String loginName(HttpSession session){
        return JSON.toJSONString(session.getAttribute("logUser"));
    }

    @RequestMapping(value = "/user/login",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String login(String username, String password, String role, HttpSession session){
        User user= null;
        try {
            user = service.login(username, password,role);
            session.setAttribute("logUser",user);
        }catch (Exception e){
        }
        return JSON.toJSONString(user);
    }

    /**
     * 查询全部用户
     * @param page
     * @param size
     * @param checkName
     * @param type
     * @return
     */
    @RequestMapping(value = "/user/findAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public Layui findall(@RequestParam(name = "page",defaultValue = "1") int page,
                         @RequestParam(name = "limit",defaultValue = "5") int size,
                         @RequestParam(name = "username",defaultValue = "") String checkName,
                         @RequestParam(name = "type",defaultValue = "") String type){
        PageHelper.startPage(page,size);
        List<User> users = service.findAll(checkName,type);
        PageInfo info = new PageInfo(users);
        Layui layui = Layui.data(info.getTotal(), info.getList());
        return layui;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/addUser")
    @ResponseBody
    public boolean addUser(User user){
        boolean b = service.addUser(user);
        return b;
    }

    /**
     * 删除用户
     * @param username
     * @return
     */
    @RequestMapping("/user/delUser")
    @ResponseBody
    public String delUser(String username){
        service.delUser(username);
        return "";
    }

    /**
     * 根据名称查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/findByNameBoolean",produces = "application/json;charset=utf-8")
    @ResponseBody
    public boolean findByName1(String username){
        User user = service.findByName(username);
        if (user==null){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 根据名称查询用户信息
     * @param username
     * @return
     */
    @RequestMapping(value = "/user/findByName",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findByName(String username){
        User user = service.findByName(username);
        return JSON.toJSONString(user);
    }


    /**
     * 用户信息更新
     * @param name
     * @param user
     * @return
     */
    @RequestMapping("/user/updataUser")
    @ResponseBody
    public boolean updataUser(String name, User user){
        boolean b = service.updataUser(name, user);
        return true;
    }

    /**
     * 跳转到updateUser.html页面
     * @param username
     * @return
     */
    @RequestMapping("/toUpdateUser")
    public String updateUser(String username){
        return "forward:views/admin/UserOperate/updateUser.html";
    }
}
