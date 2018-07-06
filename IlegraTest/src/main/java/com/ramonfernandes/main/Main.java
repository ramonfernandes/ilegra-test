package com.ramonfernandes.main;

import com.ramonfernandes.thread.ThreadCheckForNewFiles;


public class Main {
    public static void main(String[] args){
        Thread thread = new Thread(new ThreadCheckForNewFiles().getRunnable());
        thread.start();
    }
}
