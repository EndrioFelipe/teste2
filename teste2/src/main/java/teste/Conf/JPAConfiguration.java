package teste.Conf;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfiguration {
	
	@Autowired
	private Environment env;
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassName("com.postgresql.Driver");
       
        URI dbUrl = new URI(env.getProperty("DATABASE_URL"));
        dataSource.setUrl("jdbc:postgresql://"+dbUrl.getHost()+":"+dbUrl.getPort()+dbUrl.getPath());
        //dataSource.setUrl("jdbc:mysql://localhost:3306/teste2");
        //dataSource.setUsername("endrio");
        dataSource.setUsername(dbUrl.getUserInfo().split(":")[0]); 
       // dataSource.setPassword("password");
        dataSource.setPassword(dbUrl.getUserInfo().split(":")[1]);

        factoryBean.setDataSource(dataSource);

		/*
		 * Properties props = new Properties(); props.setProperty("hibernate.dialect",
		 * "org.hibernate.dialect.MySQL5Dialect");
		 * props.setProperty("hibernate.show_sql", "true");
		 * props.setProperty("hibernate.hbm2ddl.auto", "update");
		 */
         Properties props = new Properties(); props.setProperty("hibernate.dialect",
		 "org.hibernate.dialect.PostgreSQLDialect");
		 props.setProperty("hibernate.show_sql", "true");
		 props.setProperty("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("teste.models");

        return factoryBean;
    }
	
	@Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }
	
}
