package cn.liasoux.mapper;

import cn.liasoux.pojo.Purchase;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseMapper {


    /**
     * 查询全部信息
     * @return
     */
    @Select("select * from purchase where material like #{material}")
    @Results(value = {
            @Result(id = true,column = "material",property = "material"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "price",property = "price"),
            @Result(column = "time",property = "time"),
            @Result(column = "name",property = "name"),
            @Result(column = "category",property = "mateName",
            one = @One(select = "cn.liasoux.mapper.MateCateMapper.findByCodeName"))
    })
    List<Purchase> findAll(String material);

    /**
     * 查询全部信息
     * @return
     */
    @Select("select * from purchase where category = #{cate} and material like #{material}")
    @Results(value = {
            @Result(id = true,column = "material",property = "material"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "price",property = "price"),
            @Result(column = "time",property = "time"),
            @Result(column = "name",property = "name"),
            @Result(column = "category",property = "mateName",
                    one = @One(select = "cn.liasoux.mapper.MateCateMapper.findByCodeName"))
    })
    List<Purchase> findAllCate(@Param("cate") String cate,@Param("material") String material);

    /**
     * 添加采购计划
     * @param purchase
     * @return
     * @throws Exception
     */
    @Insert("INSERT INTO purchase (category,material, quantity, price, time, name) VALUES (#{category},#{material},#{quantity},#{price}, #{time},#{name})")
    boolean addPurchase(Purchase purchase)throws Exception;

    /**
     * 更新采购信息
     * @param purchase
     * @return
     * @throws Exception
     */
    @Update("update purchase set quantity = #{quantity},category = #{category},price = #{price},time = #{time},name = #{name} where material = #{material}")
    boolean updatepur(Purchase purchase)throws Exception;

    /**
     * 查询库存中是否存在该药品
     * @param material
     * @return
     * @throws Exception
     */
    @Select("select * from purchase where material = #{material} and name = #{name} and quantity = #{quantity} ")
    Purchase findByMaterial(@Param("material") String material,@Param("name") String name,@Param("quantity") int quantity)throws Exception;

    /**
     * 删除采购信息！
     * @param material
     * @param name
     * @param quantity
     * @return
     * @throws Exception
     */
    @Delete("delete from purchase where material = #{material} and name = #{name} and quantity = #{quantity}")
    boolean delPurchase(@Param("material") String material,@Param("name") String name,@Param("quantity") int quantity)throws Exception;


}
