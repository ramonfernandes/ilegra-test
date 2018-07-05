package com.ramonfernandes.collections;

import com.ramonfernandes.pojo.Salesman;

import java.util.ArrayList;
import java.util.List;

public class SalesmanCollection {

    private List<Salesman> salesmanList;
    private static SalesmanCollection salesmanCollection = new SalesmanCollection();

    private SalesmanCollection(){
        salesmanList = new ArrayList<Salesman>();
    }

    public static SalesmanCollection getInstanceOf(){
        return salesmanCollection;
    }

    public Salesman getSalesmanByCNPJ(String cnpj){
        for(Salesman salesman : salesmanList)
            if(salesman.getCnpj().equals(cnpj))
                return salesman;
        return null;
    }

    public List<Salesman> getSalesmanByName(String name){
        List <Salesman> result = new ArrayList<Salesman>();
        for(Salesman salesman : salesmanList)
            if(salesman.getName().equals(name))
                result.add(salesman);
        return result;
    }
}
