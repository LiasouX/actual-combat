package cn.liasoux.mapper;

import cn.liasoux.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    @Select("select * from user where username = #{name} and password = #{passwd} and type = #{role}")
    User login(@Param("name") String username,@Param("passwd") String password,@Param("role") String role);


    /**
     * 默认全部查询
     * @param checkName
     * @return
     */
    @Select("select * from user where username like #{checkName}")
    List<User> findAll(@Param("checkName") String checkName);

    /**
     * 按照type来区分
     * @param checkName
     * @param type
     * @return
     */
    @Select("select * from user where username like #{checkName} and type = #{type}")
    List<User> findAllType(@Param("checkName") String checkName,@Param("type") String type);

    /**
     * 添加用户
     * @param user
     */
    @Insert("INSERT INTO user (type, username, password, sex, phone) VALUES (#{type}, #{username}, #{password}, #{sex}, #{phone})")
    void addUser(User user);

    /**
     * 删除用户
     * @param username
     */
    @Delete("delete from user where username = #{username}")
    void delUser(String username);

    /**
     * 按照username查询数据
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User findByName(String username);

    /**
     * 更新数据
     * @param name
     * @param user
     * @return
     */
    @Update("update user set username=#{user.username},password = #{user.password},type = #{user.type},sex = #{user.sex},phone = #{user.phone} where username = #{name}")
    boolean updataUser(@Param("name") String name,@Param("user") User user);
}
