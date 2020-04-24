package net.paxcel.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

//import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {
	
	
	@Autowired
	  private Environment env;

//	  @Bean
//	  public DataSource getDataSource() {
//		  
//		  System.out.print("Entered");
//		MysqlDataSource  dataSource = new  MysqlDataSource ();
//	  //  dataSource.setDriverClassName(env.getProperty("mysql.driver"));
//	    dataSource.setURL(env.getProperty("mysql.jdbcUrl"));
//	    dataSource.setUser(env.getProperty("mysql.username"));
//	    dataSource.setPassword(env.getProperty("mysql.password"));
//	    System.out.print("Done creating datasource");
//	    return dataSource;
//	  }

}
