package com.ramonfernandes.fileManager;

import com.ramonfernandes.collections.CustomerCollection;
import com.ramonfernandes.collections.SaleCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InternalFileWriter {

    private static final String SUBDIRECTORY_OUT_FOLDER = System.getProperty("user.home") + "\\dir\\out";
    private static int amountSalesman = 0;
    private static int amountCustomer = 0;

    public void writeOnFile(String fileName){
        try {
        String result = "Numero de Clientes no Arquivo: " + CustomerCollection.getCustomerCollection().size() + "\n"
                + "Número de Salesman no Arquivo: " + SalesmanCollection.getSalesmanList().size() +"\n"
                + "Venda mais cara da história: " + SaleCollection.getMostExpensiveSale().getSaleID() + "\n"
                + "Pior vendedor da história: " + SaleCollection.getWorstSalesmanEver().getName();
        String pathString = SUBDIRECTORY_OUT_FOLDER + fileName;
        Path file = Paths.get(pathString);
        byte[] buffer = result.getBytes();
            Files.write(file, buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addSalesman(){
        amountSalesman++;
    }

    public static void addCustomer(){
        amountCustomer++;
    }
}
