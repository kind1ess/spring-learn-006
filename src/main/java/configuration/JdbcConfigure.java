package configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
//当AccountConfigure加了@Import(JdbcConfigure.class)时，@Component或者@Configuration就可以去掉了
//@Configuration
public class JdbcConfigure {
    /**
     * 创建一个QueryRunner对象，并将其放入ioc容器
     *
     * @param dataSource
     * @return
     */
    @Bean(name = "queryRunner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

    @Bean(name = "ds")
    public DataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mchange.v2.c3p0.ComboPooledDataSource");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/spring_learn?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }
}
