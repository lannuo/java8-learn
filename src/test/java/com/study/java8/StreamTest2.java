package com.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Stream api
 */
public class StreamTest2 {

    private List<Employee> employees= Arrays.asList(
            new Employee("张三",60,3600),
            new Employee("李四",20,1600),
            new Employee("王五",30,7600),
            new Employee("赵六",10,6600),
            new Employee("刘六",30,6600),
            new Employee("刘六",30,6600),
            new Employee("刘六",30,6600)
    );

    /**
     * 过滤 filter
     */
    @Test
    public void test1(){
        employees.stream()
                .filter((x)->x.getSaler()<6600)
                .forEach(System.out::println);
    }
    @Test
    public void test2(){
        employees.stream()
                .filter((x)->x.getSaler()<6000)
                .limit(1)
                .forEach(System.out::println);

    }
    @Test
    public void test3(){
        employees.stream()
                .filter((x)->x.getSaler()<6000)
                .skip(1)
                .forEach(System.out::println);
    }
    @Test
    public void test4(){
        employees.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
