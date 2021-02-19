package cn.liasoux.service;

import cn.liasoux.pojo.Output;

import java.util.List;

public interface OutputService {

    /**
     * 查询全部
     * @param name
     * @param mata
     * @return
     */
    List<Output> findAll(String name, String mata);

    /**
     * 修改审核状态
     * @return
     */
    boolean updateStatus(String status, String name,String material) throws Exception;
}
