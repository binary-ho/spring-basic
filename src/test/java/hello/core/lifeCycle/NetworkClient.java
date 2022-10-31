package hello.core.lifeCycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {

    private String url;
    
    public NetworkClient() {
        System.out.println("constructor url = " + url);
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    // 서비스 시작시 호출
    public void connect() {
        System.out.println("url = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + ", message = " + message);
    }

    public void disconnect() {
        System.out.println("Close!: " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        connect();
        call("init network connection");
    }

    @PreDestroy
    public void close() throws Exception {
        disconnect();
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("init network connection");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }
}
