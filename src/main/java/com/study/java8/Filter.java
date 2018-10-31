package com.study.java8;
@FunctionalInterface
public interface Filter<T> {

    boolean test(T t);
}
