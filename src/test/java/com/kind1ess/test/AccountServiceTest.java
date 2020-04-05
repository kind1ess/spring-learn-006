package com.kind1ess.test;

import com.kind1ess.config.AccountConfigure;
import com.kind1ess.model.Account;
import com.kind1ess.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 单元测试
 *
 * RunWith注解：
 *      作用：将junit的运行器替换为spring的运行器，这样就可以从ioc容器中自动装配bean。
 *      需要导入坐标<dependency>
 *             <groupId>org.springframework</groupId>
 *             <artifactId>spring-test</artifactId>
 *             <version>5.2.4.RELEASE</version>
 *         </dependency>
 * ContextConfiguration注解：
 *      locations：用于指定xmml配置的位置，加上classpath关键字表示在类路径下。
 *      classes：指定注解类的Class对象
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AccountConfigure.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService;
    @Test
    public void testFindAll() {
        //获取容器
        System.out.println(accountService.findAllAccount());;
    }

    @Test
    public void testFindById() {
        System.out.println(accountService.findAccountById(2));
    }

    @Test
    public void testSave() {
        accountService.saveAccount(new Account(1,"张三", 13262.3f));
        System.out.println(accountService.findAllAccount());
    }

    @Test
    public void testUpdate() {
        Account account = accountService.findAccountById(4);
        account.setMoney(26316.42f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDelete() {
        accountService.deleteAccountById(6);
        System.out.println(accountService.findAllAccount());
    }
}
