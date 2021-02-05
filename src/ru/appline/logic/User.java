package ru.appline.logic;

public class User {
    private String name;
    private String surname;
    private double salary;

    public User(String name, String surname, double salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public User setSalary(double salary) {
        this.salary = salary;
        return this;
    }
}
