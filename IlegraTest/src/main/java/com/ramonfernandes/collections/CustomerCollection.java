package com.ramonfernandes.collections;

import com.ramonfernandes.fileManager.InternalFileWriter;
import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.Sale;

import java.util.ArrayList;
import java.util.List;

public class CustomerCollection {

    private static List<Customer> customerList;
    private static CustomerCollection instance = new CustomerCollection();

    private CustomerCollection() {
        customerList = new ArrayList<Customer>();
    }

    public static CustomerCollection getInstanceOf() {
        return instance;
    }

    public static void restartList() {
        customerList = new ArrayList<Customer>();
    }

    public static void addCustomer(Customer customer) {
        if (!customerList.contains(customer)) {
            customerList.add(customer);
            InternalFileWriter.addCustomer();
        }
    }

    public static void setCustomerList(ArrayList<Customer> list){
        customerList = list;
    }

    public static List<Customer> getCustomerCollection() {
        return customerList;
    }
}
