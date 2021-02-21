package cn.liasoux.service.impl;

import cn.liasoux.mapper.OutputMapper;
import cn.liasoux.pojo.Output;
import cn.liasoux.pojo.wuzi;
import cn.liasoux.service.IntputService;
import cn.liasoux.service.OutputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@Service
public class OutputServiceImpl implements OutputService {

    @Autowired
    private OutputMapper mapper;

    @Autowired
    private IntputService service;
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
    public boolean updateStatus(String status, String name, String material,int quan) throws Exception {
        wuzi purchase = service.findPurchase();
        Set<String> strings = purchase.keySet();
        for (String string : strings) {
            if (material.equals(string)){

                Integer integer = purchase.get(string);
                Integer integer1 = (Integer) quan;
                int i = integer - integer1;
                if (i>=0){
                    return mapper.updateStatus(status, name, material);
                }
            }
        }
        return false;

    }




    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    @Override
    public boolean addOutput(Output output) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        output.setApply_status("N");
        output.setApply_time(sdf.parse(output.getApply_time_str()));

        return mapper.addOutput(output);
    }


    /**
     * 更新入库信息
     * @param output
     * @param mate
     * @param name
     * @return
     */
    @Override
    public boolean updateOutput(Output output, String mate, String name) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        output.setApply_status("N");
        output.setApply_time(sdf.parse(output.getApply_time_str()));
        return mapper.updateOutput(output, mate, name);
    }



    /**
     * 删除库存
     * @param mate
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public boolean delOutput(String mate, String name) throws Exception {
        return mapper.delOutput(mate,name);
    }



    /**
     * 查询指定Ontput信息
     * @param mate
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Output findByOutput(String mate, String name) throws Exception {
        return mapper.findByOutput(mate, name);
    }

    /**
     * 全部物资公共方法
     * @param y
     * @return
     */
    @Override
    public wuzi findAll2(String y) {
        List<Output> list = mapper.findAll2(y);
        wuzi purchase = service.findPurchase();
        for (Output output : list) {
            int quantity =(Integer) output.getQuantity();
            Integer integer = purchase.get(output.getMaterial())-quantity;
            if (integer>=0){
                purchase.put(output.getMaterial(),integer);
            }
        }
        return purchase;
    }


}
