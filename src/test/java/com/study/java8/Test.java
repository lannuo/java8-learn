package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    private List<Employee> employeeList= Arrays.asList(
            new Employee("张三",60,3600),
            new Employee("李四",20,1600),
            new Employee("王五",30,7600),
            new Employee("赵六",10,6600),
            new Employee("刘六",30,6600)
    );

    //方法1 设计模式（策略模式）
    public List<Employee> filterEmployee(List<Employee> employeeList,Filter<Employee> filter){
        List<Employee> employees=new ArrayList<>();
        for (Employee obj:employeeList) {
            if(filter.test(obj)){
                employees.add(obj);
            }
        }
        return employees;
    }
    @org.junit.Test
    public void test1(){
        List<Employee> result=filterEmployee(employeeList, new Filter<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge()>20;
            }
        });
        result.forEach(System.out::println);
    }
    //方法2 lambda表达式
    @org.junit.Test
    public void test2(){
        List<Employee> result=filterEmployee(employeeList,(obj)->obj.getAge()>20);
        result.forEach(System.out::println);
    }

    //方法3 SteamApi
    @org.junit.Test
    public void test3(){

        employeeList.stream()
                .filter((obj)->obj.getAge()>20)
                .limit(2)
                .forEach(System.out::println);
    }
    @org.junit.Test
    public void test4(){
        employeeList.stream()
                .map(Employee::getAge)
                .forEach(System.out::println);
    }
    @org.junit.Test
    public void test5(){
        Collections.sort(employeeList,(e1,e2)->{
            if(e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return -e1.getAge().compareTo(e2.getAge());
            }
        });
        employeeList.forEach(System.out::println);
    }
}
