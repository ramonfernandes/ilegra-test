package com.ramonfernandes.pojo;

import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.fileManager.InternalFileWriter;

public class Salesman implements FileObject {
    private String cnpj;
    private String name;
    private double salary;

    @Override
    public FileObject buildObject(String[] separatedString) {
        return this
                .setCnpj(separatedString[1])
                .setName(separatedString[2])
                .setSalary(separatedString[3]);
    }

    @Override
    public void addToCollection() {
        SalesmanCollection.addSalesman(this);
    }

    public Salesman setCnpj(String cnpj){
        this.cnpj = cnpj;
        return this;
    }

    public Salesman setName(String name){
        this.name = name;
        return this;
    }

    public Salesman setSalary(String salary){
        this.salary = Double.parseDouble(salary);
        return this;
    }

    public String getCnpj(){
        return cnpj;
    }

    public String getName() {
        return name;
    }
}
