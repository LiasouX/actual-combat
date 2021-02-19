package cn.liasoux.service.impl;

import cn.liasoux.mapper.IntputMapper;
import cn.liasoux.pojo.Intput;
import cn.liasoux.service.IntputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntputServiceImpl implements IntputService {

    @Autowired
    private IntputMapper mapper;


    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    @Override
    public List<Intput> findAll(String name, String mata) {
        List<Intput> intputs = null;
        if ("".equals(mata)){
            intputs = mapper.findAll("%"+name+"%");
        }else{
            intputs = mapper.findAllMaCa("%"+name+"%", mata);
        }
        for (Intput intput : intputs) {
            System.out.println("=======");
            System.out.println(intput);
        }
        return intputs;
    }
}
