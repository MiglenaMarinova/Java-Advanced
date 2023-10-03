package DefiningClasses.Excersises.CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countEmployees = Integer.parseInt(scanner.nextLine());

        Map<String, ArrayList<Employee>> departmentMap = new HashMap<>();

        for (int i = 1; i <= countEmployees ; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            Employee employee = null;
            if (data.length == 6){
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee = new Employee(name, salary, position, department, email,age);
            }else if (data.length == 4){
                employee = new Employee(name,salary, position,department);
            }else if (data.length == 5){
                String forthElement = data[4];
                if (forthElement.contains("@")){
                    String email = forthElement;
                    employee = new Employee(name, salary, position,department, email);
                }else{
                    int age = Integer.parseInt(forthElement);
                    employee = new Employee(name, salary, position,department, age);
                }
            }
            if (!departmentMap.containsKey(department)){
                departmentMap.put(department, new ArrayList<>());
                departmentMap.get(department).add(employee);
            }else{
                departmentMap.get(department).add(employee);
            }
        }
        String maxAvgSalaryDepartment = departmentMap.entrySet().stream()
                .max(Comparator.comparing(entry -> getAverageSalaryDepartment(entry.getValue())))
                .get()
                .getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAvgSalaryDepartment);

        List<Employee> emloyeeList = departmentMap.get(maxAvgSalaryDepartment);
        emloyeeList.sort(Comparator.comparingDouble(employee -> employee.getSalary()));
        Collections.reverse(emloyeeList);

        for (Employee emploee : emloyeeList){
            System.out.println(emploee);
        }


    }
    public static  double getAverageSalaryDepartment(List<Employee> employees){
        double sum = 0;
        for (Employee employee : employees){
            sum += employee.getSalary();
        }
        return  sum/ employees.size();
    }







}
