package cn.liasoux.mapper;

import cn.liasoux.pojo.account;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from account where material like #{name}")
    @Results(id = "reFindAll",value = {
            @Result(column = "material",property = "material"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "money",property = "money"),
            @Result(column = "purse_name",property = "purse_name"),
            @Result(column = "apply_name",property = "apply_name"),
            @Result(column = "status",property = "status"),
            @Result(column = "category",property = "mateName",
                    one =  @One(select = "cn.liasoux.mapper.MateCateMapper.findByCodeName"))
    })
    List<account> findAll(String name);


    /**
     * 根据物资分类查询全部
     * @return
     */
    @Select("select * from account where category = #{cate} and material like #{name}")
    @ResultMap("reFindAll")
    List<account> findAllMaCa(@Param("name") String name, @Param("cate") String cate);

    /**
     * 修改审核状态
     * @return
     */
    @Update("update account set status = #{stat} where purse_name = #{name} and material = #{mate}")
    boolean updateStatus(@Param("stat") String status,@Param("mate") String material,@Param("name") String name)throws Exception;
}
