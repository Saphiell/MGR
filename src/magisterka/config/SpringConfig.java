package magisterka.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import magisterka.db.FolderDAOImpl;
import magisterka.entity.DataFile;
import magisterka.entity.Folder;
import magisterka.springfiles.services.FolderServiceImpl;



@Configuration
@EnableWebMvc
@ComponentScan("magisterka")
public class SpringConfig implements WebMvcConfigurer{

	@Bean
	public FolderDAOImpl folderDAO(){
		return new FolderDAOImpl();
	}
	
	@Bean
	public FolderServiceImpl folderService(){
		FolderServiceImpl fsi = new FolderServiceImpl();
		fsi.setFolderDAO(folderDAO());
		
		return fsi;
	}
	
	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setViewClass(JstlView.class);
	    bean.setPrefix("/WEB-INF/view/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

       // Register resource handler for CSS and JS
       registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
   
       
       // Register resource handler for images
       registry.addResourceHandler("*/images/**").addResourceLocations("/WEB-INF/images/")
            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }
	
	  @Bean(name = "viewResolver")
	  public InternalResourceViewResolver getViewResolver() {
	     InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	     viewResolver.setPrefix("/WEB-INF/views/");
	     viewResolver.setSuffix(".jsp");
	     return viewResolver;
	 }
	  
	  
	


}
