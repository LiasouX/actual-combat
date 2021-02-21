package cn.liasoux.service.impl;

import cn.liasoux.mapper.IntputMapper;
import cn.liasoux.pojo.Intput;
import cn.liasoux.service.IntputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        return intputs;
    }

    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    @Override
    public boolean addIntput(Intput intput) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String register_time_str = intput.getRegister_time_str();
        String purse_time_str = intput.getPurse_time_str();
        Date parse = sdf.parse(register_time_str);
        Date parse1 = sdf.parse(purse_time_str);
        intput.setPurse_time(parse1);
        intput.setRegister_time(parse);
        return mapper.addIntput(intput);
    }


    /**
     * 更新入库信息
     * @param intput
     * @param mate
     * @param quan
     * @param name
     * @return
     */
    @Override
    public boolean updateIntput(Intput intput, String mate, String quan, String name)throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String register_time_str = intput.getRegister_time_str();
        String purse_time_str = intput.getPurse_time_str();
        Date parse = sdf.parse(register_time_str);
        Date parse1 = sdf.parse(purse_time_str);
        intput.setPurse_time(parse1);
        intput.setRegister_time(parse);
        return mapper.updateIntput(intput,mate,quan,name);
    }


    /**
     * 删除库存
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public boolean delInput(String mate, String quan, String name) throws Exception {
        return mapper.delInput(mate,quan,name);
    }

    /**
     * 查询指定intput信息
     * @param mate
     * @param quan
     * @param name
     * @return
     * @throws Exception
     */
    @Override
    public Intput findByIntput(String mate, String quan, String name) throws Exception {
        return mapper.findByIntput(mate, quan, name);
    }


    /**
     * 查询物资数量
     * @return
     */
    @Override
    public List<String> findPurchase() {
        List<Intput> intputs = mapper.findPurchase();
        List<String> ins = null;
        for (int i = 0; i < intputs.size(); i++) {
            for (int j = i+1; j < intputs.size(); j++) {
                if (intputs.get(i).getMaterial()==intputs.get(j).getMaterial()){
                    int i1 = intputs.get(i).getQuantity() + intputs.get(j).getQuantity();
                    ins.set(i1,intputs.get(i).getMaterial());
                    intputs.remove(j);
                }
            }
        }
        return ins;
    }


}
