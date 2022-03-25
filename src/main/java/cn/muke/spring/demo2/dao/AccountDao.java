package cn.muke.spring.demo2.dao;

/**
 * 转账案例的DAO层的接口
 */
public interface AccountDao {
    /**
     * @param out 转出账号
     * @param money 转出金额
     */
    void outMoney(String out,Double money);


    void inMoney(String in,Double money);



}
