package cn.muke.spring.demo1.service.impl;

import cn.muke.spring.demo1.dao.AccountDao;
import cn.muke.spring.demo1.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 转账案例的业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    //注入转账的dao
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    //注入事务管理的模板
    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * @param out 转出账号
     * @param in 转入账号
     * @param money 转账金额
     */
    @Override
    public void transfer(String out, String in, double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(out,money);
                //int a = 5/0;
                accountDao.inMoney(in,money);
            }
        });


    }
}
