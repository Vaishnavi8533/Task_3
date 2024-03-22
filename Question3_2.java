package QuestionMaintask3;

import java.util.Scanner;

//Interface Taxable
interface Taxable {
 double salesTax = 0.07;
 double incomeTax = 0.105;

 double calcTax();
}

//Class Employee implementing Taxable interface
class Employee implements Taxable {
 private double salary;

 // Constructor
 public Employee(int empId, String name, double salary) {
     this.salary = salary;
 }

 // Method to calculate income tax on yearly salary
 @Override
 public double calcTax() {
     return salary * incomeTax;
 }
}

//Class Product implementing Taxable interface
class Product implements Taxable {
 private int pid;
 private double price;
 private int quantity;

 // Constructor
 public Product(int pid, double price, int quantity) {
     this.pid = pid;
     this.price = price;
     this.quantity = quantity;
 }

 // Method to calculate sales tax on unit price of product
 @Override
 public double calcTax() {
     return price * salesTax;
 }
}

public class Question3_2 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // Accepting employee information
     System.out.println("Enter Employee Information:");
     System.out.print("Employee ID: ");
     int empId = scanner.nextInt();
     scanner.nextLine(); // Consume newline
     System.out.print("Employee Name: ");
     String empName = scanner.nextLine();
     System.out.print("Employee Salary: ");
     double empSalary = scanner.nextDouble();
     scanner.nextLine(); // Consume newline

     // Creating Employee object
     Employee employee = new Employee(empId, empName, empSalary);

     // Accepting product information
     System.out.println("\nEnter Product Information:");
     System.out.print("Product ID: ");
     int pid = scanner.nextInt();
     System.out.print("Product Price: ");
     double price = scanner.nextDouble();
     System.out.print("Product Quantity: ");
     int quantity = scanner.nextInt();

     // Creating Product object
     Product product = new Product(pid, price, quantity);

     scanner.close();

     // Calculating and printing income tax and sales tax
     System.out.println("\nIncome Tax on Yearly Salary: $" + employee.calcTax());
     System.out.println("Sales Tax on Unit Price of Product: $" + product.calcTax());
 }
}
	
