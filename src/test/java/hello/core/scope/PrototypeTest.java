package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind() {
        // 안의 클래스에 자동으로 컴포넌트 스캔
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(PrototypeBean.class);

        PrototypeBean bean = annotationConfigApplicationContext.getBean(PrototypeBean.class);
        PrototypeBean bean2 = annotationConfigApplicationContext.getBean(PrototypeBean.class);
        System.out.println("bean = " + bean);
        System.out.println("bean2 = " + bean2);
        assertThat(bean).isNotSameAs(bean2);
        annotationConfigApplicationContext.close();
    }

    @Scope("prototype")
    static class PrototypeBean {
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
