package com.lmy.demo.websocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
//新建SpringBean获取bean的帮助类
public class SpringBean implements ServletContextListener {

    private static WebApplicationContext springContext = null;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        if (springContext == null) {
            springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub

    }

    public static Object getBean(String name) {
        return springContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return springContext.getBean(clazz);
    }
}