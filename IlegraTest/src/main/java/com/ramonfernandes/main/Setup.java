package com.ramonfernandes.main;


import com.ramonfernandes.DAO.CustomerDAO;
import com.ramonfernandes.DAO.SaleDAO;
import com.ramonfernandes.DAO.SalesmanDAO;
import com.ramonfernandes.collections.CustomerCollection;
import com.ramonfernandes.collections.SaleCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.pojo.Customer;
import com.ramonfernandes.pojo.Sale;
import com.ramonfernandes.pojo.Salesman;

import java.io.File;
import java.util.ArrayList;

public class Setup {

    public static String SUBDIRECTORY_IN_FOLDER;
    public static String SUBDIRECTORY_OUT_FOLDER;
    public static String CONF_FOLDER;

    public static boolean setup() {
        String systemHome = System.getProperty("user.home");
        if (System.getProperty("os.name").contains("Windows")) {
            SUBDIRECTORY_IN_FOLDER = systemHome + "\\dir\\in";
            SUBDIRECTORY_OUT_FOLDER = systemHome + "\\dir\\out";
            CONF_FOLDER = systemHome + "\\dir\\conf";
        } else {
            SUBDIRECTORY_IN_FOLDER = systemHome + "/dir/in/";
            SUBDIRECTORY_OUT_FOLDER = systemHome + "/dir/out/";
            CONF_FOLDER = systemHome + "/dir/conf/";
        }
        File file = new File(SUBDIRECTORY_IN_FOLDER);
        if (!file.isDirectory())
            return file.mkdirs();
        file = new File(SUBDIRECTORY_OUT_FOLDER);
        if (!file.isDirectory())
            return file.mkdirs();
        file = new File(CONF_FOLDER);
        if (!file.isDirectory())
            return file.mkdirs();
        importFromFile();
        return true;
    }

    private static void importFromFile(){
        CustomerDAO customerDAO = new CustomerDAO();
        SalesmanDAO salesmanDAO = new SalesmanDAO();
        SaleDAO saleDAO = new SaleDAO();

        CustomerCollection.setCustomerList((ArrayList<Customer>) customerDAO.getAll());
        SalesmanCollection.setSalesmanList((ArrayList<Salesman>) salesmanDAO.getAll());
        SaleCollection.setSaleList((ArrayList<Sale>) saleDAO.getAll());
    }
}
