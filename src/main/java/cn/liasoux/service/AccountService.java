package cn.liasoux.service;


import cn.liasoux.pojo.account;

import java.util.List;

public interface AccountService {
    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    List<account> findAll(String name, String mata);

    /**
     * 修改审核状态
     * @return
     */
    boolean updateStatus(String status, String name,String material) throws Exception;

    /**
     * 添加报销信息
     * @param account
     * @return
     * @throws Exception
     */
    boolean addAccount(account account)throws Exception;
}
