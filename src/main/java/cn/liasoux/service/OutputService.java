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




    /**
     * 入库添加
     * @return
     * @throws Exception
     */
    boolean addOutput(Output Output)throws Exception;


    /**
     * 更新入库信息
     * @param Output
     * @param mate
     * @param name
     * @return
     */
    boolean updateOutput(Output Output, String mate, String name)throws Exception;


    /**
     * 删除库存
     * @param mate
     * @param name
     * @return
     * @throws Exception
     */
    boolean delOutput(String mate,String name)throws Exception;

    /**
     * 查询指定intput信息
     * @param mate
     * @param name
     * @return
     * @throws Exception
     */
    Output findByOutput( String mate,String name)throws Exception;
}
