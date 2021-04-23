package com.example.zhw.springsource.producer;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class HamburgerFactory {


    //最大容积
    public static final int Max_NUM = 100;


    //当前汉堡数量
    private List<Integer> currentHamburgerList = new ArrayList<>(16);


}
