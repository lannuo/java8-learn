package com.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 终止
 */
public class StreamTest4 {
    private List<Employee> employees = Arrays.asList(
            new Employee("张三", 60, 3600, Employee.Status.BUSY),
            new Employee("李四", 20, 1600, Employee.Status.FREE),
            new Employee("王五", 30, 7600, Employee.Status.VOCATION),
            new Employee("赵六", 10, 6600, Employee.Status.BUSY),
            new Employee("刘六", 30, 6600, Employee.Status.FREE),
            new Employee("刘六", 30, 6600, Employee.Status.VOCATION),
            new Employee("刘六", 30, 6600, Employee.Status.BUSY)
    );

    @Test
    public void test(){
        boolean b1=employees.stream()
                .allMatch((e)->e.getStatus()== Employee.Status.FREE);
        System.out.println(b1);

        boolean b2=employees.stream()
                .anyMatch((e)->e.getStatus()== Employee.Status.FREE);
        System.out.println(b2);

        boolean b3=employees.stream()
                .noneMatch((e)->e.getStatus()== Employee.Status.FREE);
        System.out.println(b3);

        Optional<Employee> o1=employees.stream()
                .findFirst();
        System.out.println(o1.get());

        Optional<Employee> o2=employees.parallelStream()
                .filter((e)->e.getSaler()>3000)
                .findAny();
        System.out.println(o2.get());

        long num=employees.stream().count();
        System.out.println("num"+num);

        Optional<Employee> o3=employees.stream()
                .max(Comparator.comparing(Employee::getSaler));
        System.out.println(o3.get());

        Optional<Integer> min=employees.stream()
                .map(Employee::getAge)
                .min(Integer::compareTo);
        System.out.println("min"+min.get());


        employees.stream()
                .sorted(Comparator.comparing(Employee::getSaler))
                .forEach(System.out::println);
    }
}