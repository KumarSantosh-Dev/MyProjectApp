package in.nit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableTransactionManagement     //enable HTXMgmt
@EnableWebMvc                    //Activate Spring Web-MVC
@PropertySource("classpath:app.properties")   //load Properties into Spring Container
@ComponentScan("in.nit")         //all layered common Packages name
public class AppConfig implements WebMvcConfigurer{

	@Autowired
	private Environment env;

	@Bean
	public DataSource ds() {
		BasicDataSource d=new BasicDataSource();
		d.setDriverClassName(env.getProperty("db.driver"));
		d.setUrl(env.getProperty("db.url"));
		d.setUsername(env.getProperty("db.username"));
		d.setPassword(env.getProperty("db.password"));

		return d;
	}

	@Bean
	public LocalSessionFactoryBean sesFactory() {
		LocalSessionFactoryBean ses=new LocalSessionFactoryBean();
		ses.setDataSource(ds());
		ses.setHibernateProperties(props());
		//ses.setAnnotatedClasses(null);
		ses.setPackagesToScan("in.nit.model");
		return ses;
	}

	@Bean
	public Properties props() {

		Properties p=new Properties();
		p.put("hibernate.dialect",env.getProperty("orm.dialect"));
		p.put("hibernate.show_sql",env.getProperty("orm.showsql"));
		p.put("hibernate.format_sql",env.getProperty("orm.fmtsql"));
		p.put("hibernate.hbm2ddl.auto",env.getProperty("orm.ddlauto"));
		return p;
	}

	@Bean
	public HibernateTemplate ht() {

		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sesFactory().getObject());
		return h;
	}

	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager ht=new HibernateTransactionManager();
		ht.setSessionFactory(sesFactory().getObject());
		return ht;
	}

	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix(env.getProperty("mvc.prefix"));
		iv.setSuffix(env.getProperty("mvc.suffix"));
		return iv;
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}
	
	 // @Bean 
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/resources/**")
	  .addResourceLocations("/resources/"); 
	  }
	 
	}
