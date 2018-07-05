package com.ramonfernandes.filereader;

import com.ramonfernandes.factory.Factory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InternalFileReader {

    public boolean readFile(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while(line != null)
                for (String subLine: line.split(" "))
                    createPojoFromLine(subLine);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void createPojoFromLine(String line){
        String[] separatedString = line.split("ç");
        Factory.getInstanceOfFactory().getInstanceOfFile(separatedString[0]);
    }
}
