package com.ramonfernandes.fileManager;

import com.ramonfernandes.collections.CustomerCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.factory.Factory;
import com.ramonfernandes.pojo.FileObject;

import java.io.*;

public class InternalFileReader {

    private static InternalFileReader internalFileReader = new InternalFileReader();

    public static InternalFileReader getInstanceOf() {
        return internalFileReader;
    }

    public void getNewFilesOnFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (readFile(folder.getPath() + "\\" + fileEntry.getName()))
                System.out.println("File: " + folder.getName() + fileEntry + " succesfully storaged ");
        }
    }

    public boolean readFile(String filePath) {
        CustomerCollection.restartList();
        SalesmanCollection.restartList();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filePath), "ISO-8859-1"));
            String line = bufferedReader.readLine();
            while (line != null) {
                line = line.replace(" 00", "@00");
                for (String subLine : line.split("@"))
                    if (!createPojoFromLine(subLine))
                        return false;
                line = bufferedReader.readLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean createPojoFromLine(String line) {
        String[] separatedString = line.split("ç");
        FileObject file = Factory.getInstanceOfFactory().getInstanceOfFile(separatedString[0]);
        file.buildObject(separatedString);
        return true;
    }
}
