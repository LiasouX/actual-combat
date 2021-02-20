package cn.liasoux.service.impl;

import cn.liasoux.mapper.AccountMapper;
import cn.liasoux.pojo.account;
import cn.liasoux.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper mapper;

    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    @Override
    public List<account> findAll(String name, String mata) {
        List<account> accounts = null;
        if ("".equals(mata)){
            accounts = mapper.findAll("%"+name+"%");
        }else{
            accounts = mapper.findAllMaCa("%"+name+"%",mata);
        }
        return accounts;
    }

    /**
     * 修改审核状态
     * @return
     */
    @Override
    public boolean updateStatus(String status, String name,  String material) throws Exception {
        return mapper.updateStatus(status, name, material);
    }

    /**
     * 添加报销信息
     * @param account
     * @return
     * @throws Exception
     */
    @Override
    public boolean addAccount(account account) throws Exception {
        account.setStatus("N");
        return mapper.addAccount(account);
    }
}
