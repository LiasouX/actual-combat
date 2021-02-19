package cn.liasoux.service.impl;

import cn.liasoux.mapper.OutputMapper;
import cn.liasoux.pojo.Output;
import cn.liasoux.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutputServiceImpl implements OutputService {

    @Autowired
    private OutputMapper mapper;

    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    @Override
    public List<Output> findAll(String name, String mata) {
        List<Output> outputs = null;
        if ("".equals(mata)){
            outputs = mapper.findAll("%" + name + "%");
            System.out.println("=================");
        }else{
            outputs = mapper.findAllMaCa("%"+name+"%", mata);
        }

        return outputs;
    }

    /**
     * 修改审核状态
     * @return
     */
    @Override
    public boolean updateStatus(String status, String name, String material) throws Exception {
        return mapper.updateStatus(status, name, material);
    }


}
