package spring;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import util.ApplicationUtil;

/**
 * @brief Morgan财务服务启动
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,DataSourceTransactionManagerAutoConfiguration.class, MybatisAutoConfiguration.class})

public class Application {
	public static void main(String[] args) {

		System.out.println( "Hello World!" );
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);

		System.out.println(args);
		System.out.println( "11111" );
		System.out.println(applicationContext);
		System.out.println( "22222" );
		ApplicationUtil.setApplicationContext(applicationContext);
		  System.out.println("aaa"+ApplicationUtil.getApplicationContext());
		WebApplicationType webApplicationType = null;
		BeanFactory beanFactory = applicationContext.getParentBeanFactory();
		beanFactory.getBean("person");
	}
}
