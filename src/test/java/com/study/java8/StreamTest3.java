package com.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {
    private List<Employee> employees= Arrays.asList(
            new Employee("张三",60,3600),
            new Employee("李四",20,1600),
            new Employee("王五",30,7600),
            new Employee("赵六",10,6600),
            new Employee("刘六",30,6600),
            new Employee("刘六",30,6600),
            new Employee("刘六",30,6600)
    );
    @Test
    public void test1(){
        List<String> list=Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map((e)->e.toUpperCase())
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getAge)
                .forEach(System.out::println);

        list.stream()
                .sorted()
                .forEach(System.out::println);
    }
}
