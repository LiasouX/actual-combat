package cn.liasoux.service;

import cn.liasoux.pojo.MateCate;

import java.util.List;

public interface MateCateService {
    /**
     * 查询全部物资分类信息
     * @return
     */
    List<MateCate> findAll();
    /**
     * 添加物资分类信息
     * @param mateCate
     * @return
     * @throws Exception
     */
    boolean addMateCate(MateCate mateCate) throws Exception;


    /**
     * 删除物资分类信息
     * @param code
     * @return
     * @throws Exception
     */
    boolean delMateCate(String code) throws Exception;


    /**
     * 根据名称查询出物资分类信息
     * @param code
     * @return
     * @throws Exception
     */
    MateCate findByCode(String code)throws Exception;

    /**
     * 更新物资分类信息
     * @param mateCate
     * @param cd
     * @return
     * @throws Exception
     */
    boolean updateMateCate(MateCate mateCate, String cd)throws Exception;
}
