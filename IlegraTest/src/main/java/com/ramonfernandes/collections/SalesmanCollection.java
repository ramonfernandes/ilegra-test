package com.ramonfernandes.collections;

import com.ramonfernandes.fileManager.InternalFileWriter;
import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.Salesman;

import java.util.ArrayList;
import java.util.List;

public class SalesmanCollection {

    private static List<Salesman> salesmanList;
    private static SalesmanCollection instance = new SalesmanCollection();
    private SalesmanCollection(){
        salesmanList = new ArrayList<Salesman>();
    }

    public static SalesmanCollection getInstanceOf() {
        return instance;
    }

    public static void restartList() {
        salesmanList = new ArrayList<Salesman>();
    }

    public List<Salesman> getSalesmanByName(String name){
        List <Salesman> result = new ArrayList<Salesman>();
        for(Salesman salesman : salesmanList)
            if(salesman.getName().equals(name))
                result.add(salesman);
        return result;
    }

    public static void setSalesmanList(ArrayList<Salesman> list){
        salesmanList = list;
    }

    public static void addSalesman(Salesman salesman){
        if(!salesmanList.contains(salesman)) {
            salesmanList.add(salesman);
            InternalFileWriter.addSalesman();
        }
    }

    public static List<Salesman> getSalesmanList() {
        return salesmanList;
    }
}
