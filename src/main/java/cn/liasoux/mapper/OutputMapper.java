package cn.liasoux.mapper;

import cn.liasoux.pojo.Output;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutputMapper {

    /**
     * 查询全部
     * @return
     */
    @Select("select * from output where material like #{name}")
    @Results(id = "reFindAll",value = {
            @Result(column = "no",property = "no"),
            @Result(column = "name",property = "name"),
            @Result(column = "material",property = "material"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "apply_time",property = "apply_time"),
            @Result(column = "apply_status",property = "apply_status"),
            @Result(column = "category",property = "mateName",
                    one =  @One(select = "cn.liasoux.mapper.MateCateMapper.findByCodeName"))
    })
    List<Output> findAll(String name);


    /**
     * 根据物资分类查询全部
     * @return
     */
    @Select("select * from output where category = #{cate} and material like #{name}")
    @ResultMap("reFindAll")
    List<Output> findAllMaCa(@Param("name") String name, @Param("cate") String cate);

    /**
     * 修改审核状态
     * @return
     */
    @Update("update output set apply_status = #{stat} where name = #{name} and material = #{mate}")
    boolean updateStatus(@Param("stat") String status,@Param("name") String name,@Param("mate") String material)throws Exception;
}
