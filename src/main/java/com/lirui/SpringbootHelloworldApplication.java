package com.lirui;

import com.lirui.listener.MyHttpSessionListener;
import com.lirui.servlet.MyServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
// exclude = DataSourceAutoConfiguration.class 解决数据源循环依赖问题
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan
@MapperScan("com.lirui.mapper")
public class SpringbootHelloworldApplication {

    public static void main(String[] args) {
        
        SpringApplication.run(SpringbootHelloworldApplication.class, args);
    }

   /* @Bean
    public ServletRegistrationBean<MyServlet> getServletRegistrationBean(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>(new MyServlet(),"/s2");
        bean.setLoadOnStartup(1);
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean listenerRegist(){
        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
        srb.setListener(new MyHttpSessionListener());
        System.out.println("listener");
        return srb;
    }*/
}
