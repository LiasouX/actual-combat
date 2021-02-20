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


    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    @Insert("insert into intput (category,material,quantity,money,purse_time,purse_name,register_time,register_name) " +
            "values(#{category},#{material},#{quantity},#{money},#{purse_time},#{purse_name},#{register_time},#{register_name})")
    boolean addIntput(Intput intput)throws Exception;


    /**
     * 更新入库信息
     * @param intput
     * @param mate
     * @param quan
     * @param name
     * @return
     */
    @Update("update intput set category = #{int.category},material = #{int.material},quantity = #{int.quantity}," +
            "money = #{int.money},purse_time = #{int.purse_time},purse_name = #{int.purse_name},register_time = #{int.register_time},register_name = #{int.register_name} " +
            "where material = #{mate},quantity = #{quan},purse_name = #{name}")
    boolean updateIntput(@Param("int") Intput intput,@Param("mate") String mate,@Param("quan") String quan,@Param("name") String name)throws Exception;


    /**
     * 删除库存
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    @Delete("delete from intput where material = #{mate},quantity = #{quan},purse_name = #{name}")
    boolean delInput(@Param("mate") String mate,@Param("quan") String quan,@Param("name") String name)throws Exception;

    /**
     * 查询指定intput信息
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    @Select("select * from intput where material = #{mate},quantity = #{quan},purse_name = #{name}")
    Intput findByIntput(@Param("mate") String mate,@Param("quan") String quan,@Param("name") String name)throws Exception;
}
