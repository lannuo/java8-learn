package com.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test2 {
    /**
     * java 8 内置的四大核心函数式接口
     *
     * Consumer<T>:消费型接口
     *      void accept(T t)
     *
     * Supplier<T>:供给型接口
     *      T get();
     *
     * Function<T,R>:函数型接口
     *      R apply(T t);
     *
     * Predicate<T>:断言型接口
     *      boolean test(T t);
     */

    //消费型接口：Consumer<T>
    @Test
    public void test1(){
        happy(2000,(money)-> System.out.println("消费了"+money));
    }
    public void happy(double money, Consumer<Double> consumer ){
        consumer.accept(money);
    }
    //供给型接口 ：Supplier<T>
    @Test
    public void test2(){
        List<Integer> integerList=getNumList(20,()-> (int)(Math.random()*100));
        integerList.forEach(System.out::println);
    }
    public List<Integer> getNumList(int num, Supplier<Integer> supplier){
        List<Integer> integerList=new ArrayList<>();
        for (int i=0;i<num;i++){
            Integer n=supplier.get();
            integerList.add(n);
        }
        return integerList;
    }

    //Function<T,R>:函数型接口
    @Test
    public void test3(){
        String newStr=getStr("\t\t\t\thello world   ",(str)->str.trim());
        System.out.println("newStr"+newStr);
    }

    public String getStr(String str, Function<String,String> function){
        return function.apply(str);
    }

    @Test
    public void test4(){
        List<String> list= Arrays.asList("study","workspace","newlife","he");
        List<String> result=filterStr(list,(str)->str.length()>5);
        result.forEach(System.out::println);
    }
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> filterList=new ArrayList<>();
        for (String str:list) {
            if(predicate.test(str)){
                filterList.add(str);
            }
        }
        return filterList;
    }
}
