package com.kind1ess.repository.impl;

import com.kind1ess.model.Account;
import com.kind1ess.repository.AccountRepository;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("accountRepository")
public class AccountRepositoryImpl implements AccountRepository {


    private QueryRunner queryRunner;

    @Autowired
    public AccountRepositoryImpl(QueryRunner queryRunner){
        this.queryRunner = queryRunner;
    }

    @Override
    public List<Account> findAllAccount() throws Exception {
        return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
    }

    @Override
    public Account findAccountById(Integer id) throws Exception {
        return queryRunner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),id);
    }

    @Override
    public boolean saveAccount(Account account) throws Exception {
       if (queryRunner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney())>0)
           return true;
       return false;
    }

    @Override
    public boolean updateAccount(Account account) throws Exception {
        if (queryRunner.update("update account set name=?,money=? where id=?",account.getName()
                ,account.getMoney(),account.getId())>0)
            return true;
        return false;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {
        if (queryRunner.update("delete from account where id=?",id)>0)
            return true;
        return false;
    }
}
