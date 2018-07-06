package com.ramonfernandes.thread;

import com.ramonfernandes.fileManager.InternalFileReader;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ThreadReadFilesAndExecute {
    private static Queue<File> listOfFilesToExecute;
    private static InternalFileReader internalFileReader;
    static final long EVEN_THREAD_SLEEP = 100;

    public ThreadReadFilesAndExecute() {
        listOfFilesToExecute = new SynchronousQueue<File>();
        internalFileReader = InternalFileReader.getInstanceOf();
    }

    private static Runnable thread = new Runnable() {
        public void run() {
            while (!listOfFilesToExecute.isEmpty()) {
                internalFileReader.getNewFilesOnFolder(listOfFilesToExecute.poll());
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
