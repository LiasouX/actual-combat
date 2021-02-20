package cn.liasoux.service.impl;

import cn.liasoux.mapper.UserMapper;
import cn.liasoux.pojo.User;
import cn.liasoux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User login(String username, String password,String role) {
        User user = mapper.login(username, password,role);
        return user;
    }

    /**
     * 查询全部账户
     * @param checkName
     * @param type
     * @return
     */
    @Override
    public List<User> findAll(String checkName,String type) {
        List<User> users = null;
        //判断是否有type的值
        if ("".equals(type)){//不存在
            users = mapper.findAll("%" + checkName + "%");
        }else {//存在
            users = mapper.findAllType("%" + checkName + "%",type);
        }
        return users;
    }

    /**
     * 添加用户的方法
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        boolean flag = false;//是否添加成功
        try {
            mapper.addUser(user);
            flag = true;
        }catch (Exception e){
            flag = false;
        }
        return flag;
    }


    /**
     * 删除用户
     * @param username
     */
    @Override
    public void delUser(String username) {
            mapper.delUser(username);
    }

    /**
     * 更新用户的方法
     * @param username
     * @param user
     * @return
     */
    @Override
    public boolean updataUser(String username,User user) {
        return mapper.updataUser(username,user);
    }


    /**
     * 按照用户名进行查询
     * @param username
     * @return
     */
    @Override
    public User findByName(String username) {
        User user = mapper.findByName(username);
        return user;
    }

    @Override
    public List<String> findByUsername(String type) {
        return mapper.findByUsername(type);
    }
}
