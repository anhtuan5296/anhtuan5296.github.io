package entity;

public class Employee {
    private static int autoId;
    private int id;
    public String name;
    public Double salary;
    public String potition;
    public Double tax;

    public Employee() {
    }

    public Employee(String name, Double salary, String potition, Double tax) {
        this.id=++autoId;
        this.name = name;
        this.salary = salary;
        this.potition = potition;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getPotition() {
        return potition;
    }

    public void setPotition(String potition) {
        this.potition = potition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "\nname='" + name + '\'' +
                "\nsalary= " + salary +"$\n " +
                ", potition='" + potition + '\'' +
                "\nThue la" + getTax() +
                '}';
    }
}