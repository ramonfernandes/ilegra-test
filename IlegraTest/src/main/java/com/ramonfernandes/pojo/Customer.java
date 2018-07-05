package com.ramonfernandes.pojo;

public class Customer implements FileObject {
    private String cpf;
    private String name;
    private double salary;

    public Customer setCPF(String cpf){
        this.cpf = cpf;
        return this;
    }

    public Customer setName(String name){
        this.name = name;
        return this;
    }

    public Customer setSalary(double salary){
        this.salary = salary;
        return this;
    }

    @Override
    public FileObject buildObject(String[] separatedString) {
        return this
                .setCPF(separatedString[1])
                .setName(separatedString[2])
                .setSalary(Double.parseDouble(separatedString[3]));
    }
}
