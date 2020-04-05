package com.kind1ess.test;

import com.kind1ess.config.AccountConfigure;
import com.kind1ess.model.Account;
import com.kind1ess.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 单元测试
 */
public class AccountServiceTest {

    @Test
    public void testFindAll() {
        //获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfigure.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService.findAllAccount());;
    }

    @Test
    public void testFindById() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfigure.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        System.out.println(accountService.findAccountById(2));
    }

    @Test
    public void testSave() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfigure.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.saveAccount(new Account(1,"张三", 13262.3f));
        System.out.println(accountService.findAllAccount());
    }

    @Test
    public void testUpdate() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfigure.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        Account account = accountService.findAccountById(4);
        account.setMoney(26316.42f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AccountConfigure.class);
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.deleteAccountById(6);
        System.out.println(accountService.findAllAccount());
    }
}
