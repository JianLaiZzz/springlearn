package com.example.zhw.common.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.LoggerContextListener;
import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import ch.qos.logback.core.spi.LifeCycle;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.net.URLDecoder;

@Component
public class CustomLogContextListener extends ContextAwareBase implements LoggerContextListener, LifeCycle {
    /**
     * 存储日志路径标识
     */
    public static final String LOG_PAHT_KEY = "log.path";

    @Override
    public void start() {
        URL urls = CustomLogContextListener.class.getProtectionDomain().getCodeSource().getLocation();
        String filePath = null;
        try {
            //转化为utf-8编码
            filePath = URLDecoder.decode(urls.getPath(), "utf-8")+"logs";
            System.out.println("CustomLogContextListener_start_filePath:" + filePath+"logs");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.setProperty(LOG_PAHT_KEY, filePath);
        Context context = getContext();
        context.putProperty(LOG_PAHT_KEY, filePath);
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isStarted() {
        return false;
    }

    @Override
    public boolean isResetResistant() {
        return false;
    }

    @Override
    public void onStart(LoggerContext context) {

    }

    @Override
    public void onReset(LoggerContext context) {

    }

    @Override
    public void onStop(LoggerContext context) {

    }

    @Override
    public void onLevelChange(Logger logger, Level level) {

    }


}
