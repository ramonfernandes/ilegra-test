package pojo;

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
}
