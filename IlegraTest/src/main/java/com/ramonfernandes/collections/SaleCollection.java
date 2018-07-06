package com.ramonfernandes.collections;

import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.Sale;
import com.ramonfernandes.pojo.Salesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaleCollection {

    private static List<Sale> salesList = new ArrayList<Sale>();
    private static SaleCollection instance = new SaleCollection();
    private static Salesman worstSalesmanSoFar;

    public static SaleCollection getInstanceOf() {
        return instance;
    }

    public static Sale getMostExpensiveSale() {
        Sale mostExpensiveSaleSoFar = null;
        int price = 0;
        for (Sale sale : salesList) {
            if (mostExpensiveSaleSoFar == null || sale.calculateSale() > price) {
                mostExpensiveSaleSoFar = sale;
                price = sale.calculateSale();
            }
        }
        return mostExpensiveSaleSoFar;
    }

    public static Salesman getWorstSalesmanEver() {
        Map<Salesman, Integer> mapOfSalesmanToSale = new HashMap<Salesman, Integer>();
        for (Sale sale : salesList) {
            Salesman salesman = sale.getSalesman();
            if (!mapOfSalesmanToSale.containsKey(salesman))
                mapOfSalesmanToSale.put(salesman, 0);
            mapOfSalesmanToSale.put(salesman, mapOfSalesmanToSale.get(salesman) + sale.calculateSale());
        }
        for (Map.Entry<Salesman, Integer> entry : mapOfSalesmanToSale.entrySet())
            if (worstSalesmanSoFar == null || mapOfSalesmanToSale.get(entry.getKey()) < mapOfSalesmanToSale.get(worstSalesmanSoFar))
                worstSalesmanSoFar = entry.getKey();
        return worstSalesmanSoFar;
    }

    public static void addSale(Sale sale) {
        salesList.add(sale);
    }

    public static void setSaleList(ArrayList<Sale> list){
        salesList = list;
    }

    public static List<Sale> getSalesList(){
        return salesList;
    }
}


