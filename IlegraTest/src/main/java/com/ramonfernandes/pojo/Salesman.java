package com.ramonfernandes.pojo;

public class Salesman implements FileObject {
    private String cnpj;
    private String name;
    private String businessArea;

    @Override
    public FileObject buildObject(String[] separatedString) {
        return this
                .setCnpj(separatedString[1])
                .setName(separatedString[2])
                .setBusinessArea(separatedString[3]);
    }

    public Salesman setCnpj(String cnpj){
        this.cnpj = cnpj;
        return this;
    }

    public Salesman setName(String name){
        this.name = name;
        return this;
    }

    public Salesman setBusinessArea(String businessArea){
        this.businessArea = businessArea;
        return this;
    }

    public String getCnpj(){
        return cnpj;
    }

    public String getName() {
        return name;
    }
}
