package com.minkook.web.ctx;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
@MapperScan(basePackages= {"com.minkook.web"})
@ComponentScan(basePackages= {"com.minkook.web"})


public class RootContext {
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

	    dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
	    dataSource.setUrl("jdbc:mariadb://172.168.0.235/mh"); //데이터베이스 생성후 moneyhubdb 로 이름 바꿀것, db소스도 수정할땐 삼각형
	    dataSource.setUsername("moneyhub");
	    dataSource.setPassword("moneyhub");
	return dataSource;

	}
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
