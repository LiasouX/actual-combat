package cn.liasoux.mapper;

import cn.liasoux.pojo.MateCate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateCateMapper {

    /**
     * 查询全部物资分类信息
     * @return
     */
    @Select("select * from material_category order by code desc")
    List<MateCate> findAll();

    /**
     * 添加物资分类信息
     * @param mateCate
     * @return
     * @throws Exception
     */
    @Insert("INSERT INTO material_category (code, name, description) VALUES (#{code}, #{name}, #{description})")
    boolean addMateCate(MateCate mateCate) throws Exception;

    /**
     * 删除物资分类信息
     * @param code
     * @return
     * @throws Exception
     */
    @Delete("delete from material_category where code = #{code}")
    boolean delMateCate(String code) throws Exception;

    /**
     * 根据名称查询出物资分类信息
     * @param code
     * @return
     * @throws Exception
     */
    @Select("select * from material_category where code = #{code}")
    MateCate findByCode(String code)throws Exception;

    /**
     * 根据code查找指定name
     * @param code
     * @return
     * @throws Exception
     */
    @Select("select name from material_category where code = #{code}")
    String findByCodeName(String code)throws Exception;

    /**
     * 更新物资分类信息
     * @param mateCate
     * @param cd
     * @return
     * @throws Exception
     */
    @Update("update material_category set code = #{mc.code},name = #{mc.name},description = #{mc.description} where code = #{cd}")
    boolean updateMateCate(@Param("mc") MateCate mateCate, @Param("cd") String cd)throws Exception;
}
