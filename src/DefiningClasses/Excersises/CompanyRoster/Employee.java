package DefiningClasses.Excersises.CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private  String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }
    public Employee(String name, double salary, String position, String department, String email, int age){
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(name + " ").append(String.format("%.2f ", salary));
        if (email != null){
            builder.append(email + " ");
        }else{
            builder.append("n/a ");
        }
        if (age == 0){
            builder.append("-1");
        }else{
            builder.append(age);
        }
        return builder.toString();
    }
}
