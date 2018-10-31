package com.study.java8;

public class FilterAge implements Filter<Employee>{
    @Override
    public boolean test(Employee employee) {
        if(employee.getAge()>20){
            return true;
        }
        return false;
    }
}
