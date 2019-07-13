package cn.rivamed.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "cn.rivamed.dao")
public class DynamicDataSourceConfig {

    @Value("${spring.datasource.primary.url}")
    private String primaryUrl;
    @Value("${spring.datasource.user.url}")
    private String userUrl;
    @Value("${mybatis.mapper-locations}")
    private String resources;

    //当两个数据库连接账号密码不一样时
//    @Value("${spring.datasource.user.username}")
//    private String userName;
//    @Value("${spring.datasource.user.password}")
//    private String password;

    @Autowired
    private HikariConfig hikariConfig;

    @Primary
    @Bean(name = "primaryDataSource")
    public DataSource getPrimaryDataSource(){
        return hikariConfig.getHikariDataSource(primaryUrl);
    }

    @Bean(name = "userDataSource")
    public DataSource getUserDataSource(){
        return hikariConfig.getHikariDataSource(userUrl);
    }

    //当两个数据库连接账号密码不一样时使用
//    @Bean(name = "userDataSource")
//    public DataSource getUserDataSource() {
//        return hikariConfig.getHikariDataSource(userUrl, userName, password);
//    }

    @Bean("dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("primaryDataSource") DataSource primaryDataSource,@Qualifier("userDataSource") DataSource miaoMoreDataSource){

        return null;
    }

}
