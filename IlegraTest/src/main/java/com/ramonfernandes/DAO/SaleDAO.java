package com.ramonfernandes.DAO;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ramonfernandes.pojo.Sale;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO implements DAO {
    @Override
    public List getAll() {
        List<Sale> SaleListFromJson = new ArrayList<Sale>();
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Sale>>() {
            }.getType();
            BufferedReader buffer = new BufferedReader(new FileReader("sale.json"));
            SaleListFromJson = gson.fromJson(buffer, type);
            if (SaleListFromJson != null)
                return SaleListFromJson;
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, criando novo arquivo vazio");
        }
        return new ArrayList<>();
    }
}