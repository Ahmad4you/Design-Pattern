package composite;

import java.util.ArrayList;
import java.util.List;

//Component interface
interface Employee {
 void showEmployeeDetails();
}

//Leaf class
class Developer implements Employee {
 private String name;
 private long empId;

 public Developer(String name, long empId) {
     this.name = name;
     this.empId = empId;
 }

 @Override
 public void showEmployeeDetails() {
     System.out.println("Developer: " + name + ", Employee ID: " + empId);
 }
}

//Composite class
class CompanyDirectory implements Employee {
 private List<Employee> employees = new ArrayList<>();

 public void addEmployee(Employee employee) {
     employees.add(employee);
 }

 public void removeEmployee(Employee employee) {
     employees.remove(employee);
 }

 @Override
 public void showEmployeeDetails() {
     System.out.println("Company Directory:");
     for (Employee employee : employees) {
         employee.showEmployeeDetails();
     }
 }
}


public class CompositePatternExample {
	public static void main(String[] args) {
        Developer dev1 = new Developer("John", 1001);
        Developer dev2 = new Developer("Jane", 1002);

        CompanyDirectory companyDirectory = new CompanyDirectory();
        companyDirectory.addEmployee(dev1);
        companyDirectory.addEmployee(dev2);

        CompanyDirectory subdirectory = new CompanyDirectory();
        Developer dev3 = new Developer("Bob", 1003);
        subdirectory.addEmployee(dev3);

        companyDirectory.addEmployee(subdirectory);

        companyDirectory.showEmployeeDetails();
    }
}
