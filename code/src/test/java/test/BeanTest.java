package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.junit4.SpringRunner;
import spring.Application;

/**
 * @brief Bean测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BeanTest implements ApplicationContextAware {

    private static final Logger logger                   = LoggerFactory.getLogger(BeanTest.class);

    private static ApplicationContext applicationContext = null;

    /**
     * @brief 设置ApplicationContext
     */
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        BeanTest.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Test
    /**
     * @brief DDMQ Carrera Bean
     */
    public void test() {
        logger.info("applicationContext:{}",applicationContext.toString());
//        logger.info("carrera_consumer_bean:{}",applicationContext.getBean("carreraConsumer").toString());
    }
}
