package com.ramonfernandes.factory;

import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.FileObject;
import com.ramonfernandes.pojo.Sale;
import com.ramonfernandes.pojo.Salesman;

public class Factory {

    private static Factory factory = new Factory();

    public static Factory getInstanceOfFactory() {
        return factory;
    }

    public FileObject getInstanceOfFile(String file) {
        switch (file) {
            case "001":
                return new Salesman();
            case "002":
                return new Customer();
            case "003":
                return new Sale();
            default:
                return null;
        }
    }

}
