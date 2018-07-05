package pojo;

public class Salesman implements FileObject {
    private String cnpj;
    private String name;
    private String businessArea;

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
}
