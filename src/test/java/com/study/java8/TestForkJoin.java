package com.study.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class TestForkJoin {

    @Test
    public void test1(){
        Instant start=Instant.now();
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinCalculate(0,100000000L);
        Long sum=pool.invoke(task);
        System.out.println(sum);
        Instant end=Instant.now();
        System.out.println("时间花费"+ Duration.between(start,end).toMillis());
    }

    @Test
    public void test2(){
        Instant start=Instant.now();
        Long sum=LongStream.rangeClosed(0,100000000L)
                .parallel()
                .reduce(0,Long::sum);
        System.out.println(sum);
        Instant end=Instant.now();
        System.out.println("时间花费"+ Duration.between(start,end).toMillis());
    }
}
