package com.ramonfernandes.DAO;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ramonfernandes.pojo.Customer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO {
    @Override
    public List getAll() {
        List<Customer> customerListFromJson = new ArrayList<Customer>();
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Customer>>() {
            }.getType();
            BufferedReader buffer = new BufferedReader(new FileReader("customer.json"));
            customerListFromJson = gson.fromJson(buffer, type);
            if (customerListFromJson != null)
                return customerListFromJson;
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, criando novo arquivo vazio");
        }
        return new ArrayList<>();
    }
}
