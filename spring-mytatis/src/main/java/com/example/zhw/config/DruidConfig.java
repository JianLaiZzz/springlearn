package com.example.zhw.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }

//    @Bean
//    public ServletRegistrationBean<StatViewServlet> statViewServlet() {
//
//        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(
//                new StatViewServlet(), "/druid/*");
//
//        //后台需要有人登录，进行配置
//        //bean.addUrlMappings(); 这个可以添加映射，我们在构造里已经写了
//        //设置一些初始化参数
//        Map<String, String> initParas = new HashMap<String, String>();
//        //它这个账户密码是固定的
//        initParas.put("loginUsername", "admin");
//        initParas.put("loginPassword", "123456");
//        //允许谁能防伪
//        //这个值为空或没有就允许所有人访问，ip白名单
//        initParas.put("allow", "");
//        //initParas.put("allow","localhost");//只允许本机访问，多个ip用逗号,隔开
//        //initParas.put("deny","");//ip黑名单，拒绝谁访问 deny和allow同时存在优先deny
//        //禁用HTML页面的Reset按钮
//        initParas.put("resetEnable", "false");
//        bean.setInitParameters(initParas);
//        return bean;
//    }

//    //再配置一个过滤器，Servlet按上面的方式注册Filter也只能这样
//    @Bean
//    public FilterRegistrationBean<WebStatFilter> webStatFilter() {
//        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>();
//        //可以设置也可以获取,设置一个阿里巴巴的过滤器
//        bean.setFilter(new WebStatFilter());
//        bean.addUrlPatterns("/*");
//        //可以过滤和排除哪些东西
//        Map<String, String> initParams = new HashMap<String, String>();
//        //把不需要监控的过滤掉,这些不进行统计
//        initParams.put("exclusions", "*.js,*.css,/druid/*");
//        bean.setInitParameters(initParams);
//        return bean;
//    }

}
