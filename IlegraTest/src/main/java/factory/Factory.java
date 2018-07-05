package factory;

import pojo.Customer;
import pojo.FileObject;
import pojo.Sale;
import pojo.Salesman;

public class Factory {

    private static Factory factory = new Factory();
    private static Customer customerFactory;
    private static Salesman salesmanFactory;
    private static Sale saleFactory;

    private Factory() {
        customerFactory = new Customer();
        salesmanFactory = new Salesman();
        saleFactory = new Sale();
    }

    public static Factory getInstanceOfFactory() {
        return factory;
    }

    public FileObject getInstanceOfFile(String file) {
        switch (file) {
            case "001":
                return salesmanFactory;
            case "002":
                return customerFactory;
            case "003":
                return saleFactory;
            default:
                return null;
        }
    }

}
