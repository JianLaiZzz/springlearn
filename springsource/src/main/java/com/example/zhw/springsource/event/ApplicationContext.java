package com.example.zhw.springsource.event;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: zhw
 * @createDate: 2020/5/26
 */
public class ApplicationContext {
    Set<ApplicationListener> applicationListenerSet;

    public ApplicationContext() {
        applicationListenerSet = new HashSet<>();
    }

    public void add(ApplicationListener eventListener) {
        this.applicationListenerSet.add(eventListener);
    }

    public void remove(ApplicationListener eventListener) {
        this.applicationListenerSet.remove(eventListener);
    }

    public void publishEvent(ApplicationEvent event) {
        applicationListenerSet.forEach(applicationListener ->
        {
            applicationListener.onApplicationEvent(event);
        });
    }
}
