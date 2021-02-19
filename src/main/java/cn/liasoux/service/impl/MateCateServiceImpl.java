package cn.liasoux.service.impl;

import cn.liasoux.mapper.MateCateMapper;
import cn.liasoux.pojo.MateCate;
import cn.liasoux.service.MateCateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MateCateServiceImpl implements MateCateService {

    @Autowired
    private MateCateMapper mapper;


    /**
     * 查询全部物资分类信息
     * @return
     */
    @Override
    public List<MateCate> findAll() {
        List<MateCate> mateCates = mapper.findAll();
        return mateCates;
    }


    /**
     * 添加物资分类信息
     * @param mateCate
     * @return
     * @throws Exception
     */
    @Override
    public boolean addMateCate(MateCate mateCate) throws Exception {
        return mapper.addMateCate(mateCate);
    }


    /**
     * 删除物资分类信息
     * @param code
     * @return
     */
    @Override
    public boolean delMateCate(String code) throws Exception {
        return mapper.delMateCate(code);
    }

    /**
     * 根据名称查询出物资分类信息
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    public MateCate findByCode(String code) throws Exception {
        return mapper.findByCode(code);
    }


    /**
     * 更新物资分类信息
     * @param mateCate
     * @param cd
     * @return
     * @throws Exception
     */
    @Override
    public boolean updateMateCate(MateCate mateCate, String cd) throws Exception {
        return mapper.updateMateCate(mateCate,cd);
    }
}
