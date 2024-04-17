package StreamsRealTimeQueries;

import java.util.*;
import java.util.stream.Collectors;

public class Employee {

    int id;

    String name;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", yearOfJoining=" + yearOfJoining +
                ", salary=" + salary +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    int age;

    String gender;

    public Employee(int id) {
        this.id = id;
    }

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    String department;

    int yearOfJoining;

    double salary;



public static void main(String[] args){
    List<Employee> employeeList = new ArrayList<Employee>();

    employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
    employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
    employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
    employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
    employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
    employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
    employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
    employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
    employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
    employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
    employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
    employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
    employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
    employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
    employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
    employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
    employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));


    //Query 3.1 : How many male and female employees are there in the organization?

    Map<String, Long> noOfMaleAndFemaleEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    System.out.println(noOfMaleAndFemaleEmployees);

    //Query 3.2 How to find employees name starting with alphabet A using stream API and sort the list based on names

   List<Employee> startsWithA= employeeList.stream().filter(s->s.getName().startsWith("A")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    System.out.print(startsWithA);

    //Query 3.3 Sort Employee based on gender and age is above 30 using Java 8 stream API
   List<Employee>sortedByGender= employeeList.stream().filter(s->s.getAge()>30).sorted(Comparator.comparing(Employee::getGender)).collect(Collectors.toList());
    System.out.println(sortedByGender);


    //Find the employess whose salary is between 1000 to 100000

    List<Employee> salaryRange=employeeList.stream().filter(s->s.getSalary()>1000&&s.getSalary()<100000).collect(Collectors.toList());
    System.out.println(salaryRange);

    //Find the employee whose department is Product Development and sort by their names

   List<Employee> sort=employeeList.stream().filter(e->e.getDepartment().equals("Product Development")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    System.out.println(sort);

    //Find the employee whose department is Product Development and sort by their names in reverse order
    employeeList.stream().filter(s->s.getDepartment().equals("Product Development")).sorted(Comparator.comparing(Employee::getName,Comparator.reverseOrder())).collect(Collectors.toList());

    //Find all the department names

   List<String> departmentNames= employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
    System.out.println(departmentNames);

    //Find all the names
//to get particular elemnts using map
    Set<String> names=employeeList.stream().map(Employee::getName).distinct().collect(Collectors.toSet());
    System.out.println(names);

    //get employees by department  names

    Map<String, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    System.out.println(collect);

    //Find the average of male and female employees

    Map<String,Double>avg=employeeList.stream().collect(Collectors.groupingBy((Employee::getGender),Collectors.averagingInt(Employee::getAge)));
    System.out.println(avg);

    //Find the highest paid employee
//maxBy returns optional
    Optional<Employee> highsestPaid=employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
    Employee highestPaidSalary=highsestPaid.get();
    System.out.println("name of employee "+highestPaidSalary.getName());

    //Query 3.5 : Get the names of all employees who have joined after 2015?

    List<String> empJoinedAfter2015 = employeeList.stream().filter(s -> s.getYearOfJoining() > 2015).map(Employee::getName).collect(Collectors.toList());
    System.out.println(empJoinedAfter2015);

    //Query 3.6 : Count the number of employees in each department?

    Map<String,Long> countByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
    System.out.println(countByDepartment);

    //Query 3.7 : What is the average salary of each department?

    Map<String, Double> avgSlaary = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    System.out.println(avgSlaary);

    //Get the details of youngest male employee in the product development department?

    Optional<Employee> collect1 = employeeList.stream().filter(s -> s.getGender().equals("Male") && s.getDepartment().equals("Product Development")).collect(Collectors.minBy(Comparator.comparingInt(Employee::getAge)));
    Employee youngestMaleEmp=collect1.get();
    System.out.println("youngest male employee is  "+ youngestMaleEmp.getName());

    //Query 3.9 : Who has the most working experience in the organization?

    Optional<Employee> collect2 = employeeList.stream().collect(Collectors.minBy(Comparator.comparingInt(Employee::getYearOfJoining)));
    Employee mostExperiencedEmp=collect2.get();

    System.out.println("most experienced wmployee name and year  "+ mostExperiencedEmp.getName()+mostExperiencedEmp.getYearOfJoining());


    //Query 3.10 : How many male and female employees are there in the sales and marketing team?

    Map<String, Long> salesAndMarketing = employeeList.stream().filter(s -> s.getDepartment().equals("Sales And Marketing")).collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    System.out.println(salesAndMarketing);

    //Query 3.11 : What is the average salary of male and female employees?
    Map<String, Double> collect3 = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    System.out.println(collect3);

   // Query 3.12 : List down the names of all employees in each department?
    Map<String, List<Employee>> collect4 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    System.out.println(collect4);

    //Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
    Optional<Employee> collect5 = employeeList.stream().collect((Collectors.maxBy(Comparator.comparing(Employee::getAge))));
     Employee oldestEmp=collect5.get();
    System.out.println("oldest emp name and age  and department  "+oldestEmp.getName()+oldestEmp.getAge()+oldestEmp.getDepartment());

}
}


