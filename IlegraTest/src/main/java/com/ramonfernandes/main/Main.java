package com.ramonfernandes.main;

import com.ramonfernandes.thread.ThreadCheckForNewFiles;
import com.ramonfernandes.thread.ThreadReadFilesAndExecute;


public class Main {
    public static void main(String[] args){
        Setup.setup();
        Thread threadCheckFiles = new Thread(new ThreadCheckForNewFiles().getRunnable());
        threadCheckFiles.start();
    }
}
