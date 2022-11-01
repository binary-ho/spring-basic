package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    void singletonBeanFind() {
        // 안의 클래스에 자동으로 컴포넌트 스캔
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SingletonBean.class);

        SingletonBean bean = annotationConfigApplicationContext.getBean(SingletonBean.class);
        SingletonBean bean2 = annotationConfigApplicationContext.getBean(SingletonBean.class);
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
        assertThat(bean).isSameAs(bean2);
        annotationConfigApplicationContext.close();
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("destroy");
        }
    }
}
