package com.kind1ess.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import configuration.JdbcConfigure;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Configuration注解：
 *      作用：指定当前类为配置类， 让这个类的作用和xml的作用一样
 *      细节：当配置类的Class对象被当作参数传入AnnotationConfigApplicationContext类的构造函数的时候，可以不写这个注解。
 * ComponentScan注解：
 *      作用：指定组件扫描的包
 *          和<context:component-scan base-package="com.kind1ess"></context:component-scan>作用相同
 * Bean注解：用于将一个对象加入ioc容器交给spring管理
 *      属性：
 *          name：用于指定bean的id，默认值是当前方法的名称
 *      细节：当创建对象的方法中有参数时，spring会在ioc容器中寻找该参数所属类的对象，如果没有则会报错。
 *          和Autowired注解寻找bean对象的方式相同，即ioc容器里如果有多个该类的对象，则按照对象名称寻找。
 * Import注解：
 *      作用：用于导入其他的配置类
 */
//@Configuration
@ComponentScan("com.kind1ess")
@Import(JdbcConfigure.class)
public class AccountConfigure {

}
