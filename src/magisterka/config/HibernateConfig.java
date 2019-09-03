package magisterka.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan({"magisterka"})
public class HibernateConfig {

	 @Bean
	 public DataSource myDataSource(){
		 
		 DriverManagerDataSource ds = new DriverManagerDataSource();        
	        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        ds.setUrl("jdbc:mysql://localhost:3306/mgr?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
	        ds.setUsername("magisterka");
	        ds.setPassword("magisterka");   
	        
	        
	        return ds;
		 
	 }
	 
	
    public Properties getHibernateProperties()
    {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.connection.pool_size", "1");
        
  
        
        return properties;
    }
	
    
    @Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(new String[] { "magisterka.entity" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		return sessionFactory;
	}
    
    @Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}

