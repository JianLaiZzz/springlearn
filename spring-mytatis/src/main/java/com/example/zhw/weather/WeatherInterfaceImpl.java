package com.example.zhw.weather;

import javax.jws.WebService;

@WebService
public class WeatherInterfaceImpl implements WeatherInterface {
    @Override
    public String queryWeather(String cityName) {
        System.out.println("获取城市名" + cityName);
        String weather = "暴雨";
        return weather;
    }
}
