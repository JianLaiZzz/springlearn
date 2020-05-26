package com.example.zhw.springsource.event;

import java.util.EventListener;

/**
 * @author: zhw
 * @createDate: 2020/5/26
 */
public interface ApplicationListener extends EventListener
{

	void onApplicationEvent(ApplicationEvent event);
}
