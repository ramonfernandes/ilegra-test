package com.ramonfernandes.fileManager;

import com.google.gson.Gson;
import com.ramonfernandes.collections.CustomerCollection;
import com.ramonfernandes.collections.SaleCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.main.Setup;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class InternalFileWriter {

    private static int amountSalesman = 0;
    private static int amountCustomer = 0;
    private static InternalFileWriter internalFileWriter = new InternalFileWriter();

    public static InternalFileWriter getInstanceOf() {
        return internalFileWriter;
    }

    public void writeOnFile(String fileName){
        try {
        String result = "Numero de Clientes no Arquivo: " + amountCustomer + "\n"
                + "Número de Vendedores no Arquivo: " + amountSalesman +"\n"
                + "Venda mais cara da história: " + SaleCollection.getMostExpensiveSale().getSaleID() + "\n"
                + "Pior vendedor da história: " + SaleCollection.getWorstSalesmanEver().getName();
        String pathString = Setup.SUBDIRECTORY_OUT_FOLDER + fileName;
        Path file = Paths.get(pathString);
        byte[] buffer = result.getBytes();
            Files.write(file, buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean saveDataOnDisk(List<?> listToJson, String filename) {
        try (FileWriter writer = new FileWriter(Setup.CONF_FOLDER + filename + ".json")) {
            String gson = new Gson().toJson(listToJson);
            writer.write(gson);
            return true;
        } catch (IOException ioExcpetion) {
            System.out.println("Problema com o arquivo de saída");
        } catch (IndexOutOfBoundsException indexException) {
            System.out.println("Tentando salvar lista vazia");
        }
        return false;
    }

    public static void restartCounters(){
        amountCustomer = 0;
        amountSalesman = 0;
    }

    public static void addSalesman(){
        amountSalesman++;
    }

    public static void addCustomer(){
        amountCustomer++;
    }
}
