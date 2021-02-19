package cn.liasoux.mapper;

import cn.liasoux.pojo.Intput;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntputMapper {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from intput where material like #{name}")
    @Results(id = "reFindAll",value = {
            @Result(column = "material",property = "material"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "money",property = "money"),
            @Result(column = "purse_time",property = "purse_time"),
            @Result(column = "purse_name",property = "purse_name"),
            @Result(column = "register_time",property = "register_time"),
            @Result(column = "register_name",property = "register_name"),
            @Result(column = "category",property = "mateName",
                    one =  @One(select = "cn.liasoux.mapper.MateCateMapper.findByCodeName"))
    })
    List<Intput> findAll(String name);


    /**
     * 根据物资分类查询全部
     * @return
     */
    @Select("select * from intput where category = #{cate} and material like #{name}")
    @ResultMap("reFindAll")
    List<Intput> findAllMaCa(@Param("name") String name, @Param("cate") String cate);
}
