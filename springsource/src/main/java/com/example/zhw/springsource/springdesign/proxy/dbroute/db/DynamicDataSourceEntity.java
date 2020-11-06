package com.example.zhw.springsource.springdesign.proxy.dbroute.db;

/**
 * @author zhangwei
 * @date 2020/11/5 15:35
 */
public class DynamicDataSourceEntity {

    private DynamicDataSourceEntity() {
    }


    private static final String DEFAULTDATASOURCE = null;


    private final static ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();


    /**
     * 清空数据源
     */
    public static void clear() {
        THREAD_LOCAL.remove();
    }


    /**
     * 获取当前数据源
     */
    public static void get() {
        THREAD_LOCAL.get();
    }


    /**
     * 设置已知名字数据源
     *
     * @param resource
     */
    public static void set(String resource) {
        THREAD_LOCAL.set(resource);
    }


    /**
     * 根据年份动态设置数据源
     *
     * @param
     */
    public static void set(int yrar) {
        THREAD_LOCAL.set("DB_" + yrar);
    }


    /**
     * 还原当前数据源
     */
    public static void restore() {
        THREAD_LOCAL.set(DEFAULTDATASOURCE);
    }


}
