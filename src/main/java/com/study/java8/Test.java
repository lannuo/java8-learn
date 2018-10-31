package com.study.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    private List<Employee> employeeList= Arrays.asList(
            new Employee("张三",60,3600),
            new Employee("李四",20,1600),
            new Employee("王五",30,7600),
            new Employee("赵六",10,6600)
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
    public void test(){

    }
}
