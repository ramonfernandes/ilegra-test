package com.ramonfernandes.DAO;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.ramonfernandes.pojo.Salesman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SalesmanDAO implements DAO {
    @Override
    public List getAll() {
        List<Salesman> SalesmanListFromJson = new ArrayList<Salesman>();
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<Salesman>>() {
            }.getType();
            BufferedReader buffer = new BufferedReader(new FileReader("salesman.json"));
            SalesmanListFromJson = gson.fromJson(buffer, type);
            if (SalesmanListFromJson != null)
                return SalesmanListFromJson;
        } catch (JsonIOException | JsonSyntaxException | FileNotFoundException e) {
            System.out.println("Arquivo não encontrado, criando novo arquivo vazio");
        }
        return new ArrayList<>();
    }
}