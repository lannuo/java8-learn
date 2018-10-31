package com.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流的创建
 * 1、创建
 * 2、中间操作
 * 3、终止操作
 */
public class StreamTest1 {

    @Test
    public void test(){
        //第一种方式
        Stream stream1=Arrays.stream(new String[3]);
        //第二种方式
        List<String> list=new ArrayList<>();
        Stream<String> stream2=list.stream();

        //第三种
        Stream<String> stream3=Stream.of("ss","222","23232sd");

        //第四种 创建无限流
        Stream<Integer> stream4=Stream.iterate(0,(x)->x+2);

        //第五种 创建无限流2
        Stream<Double> stream5=Stream.generate(()->Math.random());


    }

}
