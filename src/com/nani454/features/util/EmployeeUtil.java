package com.nani454.features.util;

import com.nani454.features.dto.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeUtil {
    public static List<Employee> createEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "John", 1000, "Finance"));
        employeeList.add(new Employee(102, "Simon", 1200, "HR"));
        employeeList.add(new Employee(103, "Teresa", 1100, "Marketing"));
        employeeList.add(new Employee(104, "Hilton", 1050, "Finance"));
        employeeList.add(new Employee(105, "Sean", 1700, "Finance"));
        employeeList.add(new Employee(106, "Helen", 1500, "HR"));
        employeeList.add(new Employee(107, "Tommy", 1050, "HR"));
        employeeList.add(new Employee(108, "Asif", 1000, "House Keeping"));
        employeeList.add(new Employee(109, "Aslam", 1000, "House Keeping"));
        employeeList.add(new Employee(110, "James", 1050, "Marketing"));
        employeeList.add(new Employee(111, "John", 1400, "Marketing"));
        employeeList.add(new Employee(112, "Connor", 1700, "HR"));
        employeeList.add(new Employee(113, "John", 1250, "Finance"));
        employeeList.add(new Employee(114, "Justin", 1400, "Marketing"));
        employeeList.add(new Employee(115, "Sean", 1500, "HR"));
        return employeeList;
    }

    public static void printEmployeeList(List<Employee> empList) {
        System.out.println("=================================");
        System.out.println("Emp Id\tName\tSalary\tDept.");
        System.out.println("=================================");
        empList.forEach(e -> System.out.println(e.getEmpId() + "\t\t" + e.getEmpName() + "\t" + e.getSalary() + "\t" + e.getDept()));
    }

    public static void printDeptEmployeeMap(Map<String, List<Employee>> deptEmployeeMap) {
        deptEmployeeMap.forEach((dept, employees) -> {
            System.out.println("List of employees for dept. " + dept);
            EmployeeUtil.printEmployeeList(employees);
        });
    }
}
