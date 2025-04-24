package co.edu.umanizales.myfirstapi.model;

public class Seller {
    private String name;
    private int age;
    private String city;
    private double salary;

    public Seller(String name, int age, String city, double salary) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.salary = salary;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
