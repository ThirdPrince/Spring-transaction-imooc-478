package cn.muke.spring.demo2.dao.impl;

import cn.muke.spring.demo2.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public void outMoney(String out, Double money) {

        String sql = "update account set money = money -? where name = ?";
        this.getJdbcTemplate().update(sql,money,out);
    }

    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money +? where name = ?";
        this.getJdbcTemplate().update(sql,money,in);
    }
}
