package com.ramonfernandes.thread;

import com.ramonfernandes.collections.CustomerCollection;
import com.ramonfernandes.collections.SaleCollection;
import com.ramonfernandes.collections.SalesmanCollection;
import com.ramonfernandes.fileManager.InternalFileReader;
import com.ramonfernandes.fileManager.InternalFileWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ThreadReadFilesAndExecute {
    private static List<File> listOfFilesToExecute = Collections.synchronizedList(new ArrayList<File>());
    private static InternalFileReader internalFileReader;
    private static InternalFileWriter internalFileWriter;
    static final long THREAD_SLEEP = 100;

    public ThreadReadFilesAndExecute() {
        internalFileReader = InternalFileReader.getInstanceOf();
        internalFileWriter = InternalFileWriter.getInstanceOf();
    }

    private static Runnable thread = new Runnable() {
        public void run() {
            try {
                File file = null;
                while (!listOfFilesToExecute.isEmpty()) {
                    System.out.println("Executando importação do arquivo");
                    file = listOfFilesToExecute.get(0);
                    listOfFilesToExecute.remove(0);
                    if (file.getName().endsWith(".dat"))
                        internalFileReader.getNewFilesOnFolder(file);
                }
                internalFileWriter.writeOnFile(file.getName());
                internalFileWriter.saveDataOnDisk(CustomerCollection.getCustomerCollection(), "customer");
                internalFileWriter.saveDataOnDisk(SaleCollection.getSalesList(), "sale");
                internalFileWriter.saveDataOnDisk(SalesmanCollection.getSalesmanList(), "salesman");
                Thread.sleep(THREAD_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void addToQueue(String fileToAdd) {
        listOfFilesToExecute.add(new File(fileToAdd));
    }

    public Runnable getRunnable() {
        return thread;
    }
}
