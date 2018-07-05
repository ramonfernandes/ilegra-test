package com.ramonfernandes.pojo;

public class Customer implements FileObject {
    private String cnpj;
    private String name;
    private String businessArea;

    public Customer setCNPJ(String cpf){
        this.cnpj = cnpj;
        return this;
    }

    public Customer setName(String name){
        this.name = name;
        return this;
    }

    public Customer setBusinessArea(String businessArea){
        this.businessArea = businessArea;
        return this;
    }

    @Override
    public FileObject buildObject(String[] separatedString) {
        return this
                .setCNPJ(separatedString[1])
                .setName(separatedString[2])
                .setBusinessArea(separatedString[3]);
    }
}
