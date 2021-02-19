package cn.liasoux.service;

import cn.liasoux.pojo.User;

import java.util.List;

public interface UserService {
    //登录
    User login(String username,String password,String role);
    //查询全部账户
    List<User> findAll(String checkName,String type);
    //添加用户
    boolean addUser(User user);
    //删除用户
    void delUser(String username);
    //更新用户
    boolean updataUser(String name,User user);
    //
    User findByName(String username);
}
