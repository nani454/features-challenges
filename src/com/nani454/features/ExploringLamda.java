package com.nani454.features;

import com.nani454.features.dto.Employee;
import com.nani454.features.util.EmployeeUtil;

import java.util.*;
import java.util.stream.Collectors;

public class ExploringLamda {
    public static void main(String[] args) {
        List<Employee> empList = EmployeeUtil.createEmployeeList();
        EmployeeUtil.printEmployeeList(empList);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of filter to fetch employee list with employee name \"Sean\"");
        //To convert stream to a list we use streamVar.collect(Collectors.toList())
        EmployeeUtil.printEmployeeList(empList.stream().filter(e -> e.getEmpName().equals("Sean")).collect(Collectors.toList()));

        //List of all depts fetched from employee list using set and distinct
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of  filter to fetch all depts fetched from employee list using set");
        System.out.println(empList.stream().map(Employee::getDept).collect(Collectors.toSet()));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of  filter to fetch all depts fetched from employee list using distant");
        System.out.println(empList.stream().map(Employee::getDept).distinct().collect(Collectors.toList()));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        //Count of depts
        System.out.println("Total number of depts: " +
                 + empList.stream().map(Employee::getDept).distinct().count());

        //prepare a map with dept as key and value with list of employees (Map<String,List<Employee>>))
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of map with dept as key and value with list of employees");
        Map<String,List<Employee>> deptMap =
                        empList.stream().collect(Collectors.groupingBy(Employee::getDept));

        EmployeeUtil.printDeptEmployeeMap(deptMap);

        //prepare a map with dept as key and value with list of employees sorted by salary (Map<String,List<Employee>>))
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of map with dept as key and value with list of employees sorted by salary");
        deptMap = empList.stream().sorted(Comparator.comparingInt(Employee::getSalary)).
                        collect(Collectors.groupingBy(Employee::getDept,LinkedHashMap::new,Collectors.toList()));

        EmployeeUtil.printDeptEmployeeMap(deptMap);
        //prepare a map with dept as key and value with list of employees sorted by salary desc(Map<String,List<Employee>>))
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Results of map with dept as key and value with list of employees sorted by salary descending");
        deptMap = empList.stream().sorted((e1,e2)->e2.getSalary()- e1.getSalary()).
                collect(Collectors.groupingBy(Employee::getDept,LinkedHashMap::new,Collectors.toList()));

        EmployeeUtil.printDeptEmployeeMap(deptMap);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
