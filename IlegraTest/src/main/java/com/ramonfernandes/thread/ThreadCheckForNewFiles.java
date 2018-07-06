package com.ramonfernandes.thread;

import com.ramonfernandes.main.Setup;

import java.io.IOException;
import java.nio.file.*;

public class ThreadCheckForNewFiles {
    static final long THREAD_SLEEP = 100;

    private static Runnable thread = new Runnable() {
        public void run() {
            while (true) {
                try {
                    System.out.println("Procurando novos arquivos");
                    WatchService watcher = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(Setup.SUBDIRECTORY_IN_FOLDER);
                    path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
                    WatchKey watchKey;
                    while ((watchKey = watcher.take()) != null) {
                        for (WatchEvent<?> event : watchKey.pollEvents()) {
                            ThreadReadFilesAndExecute.addToQueue(Setup.SUBDIRECTORY_IN_FOLDER + event.context());
                            System.out.println("A file was created: " + event.context());
                            Thread threadExecute  = new Thread(new ThreadReadFilesAndExecute().getRunnable());
                            threadExecute.start();
                        }
                        watchKey.reset();
                    }
                    Thread.sleep(THREAD_SLEEP);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    public Runnable getRunnable() {
        return thread;
    }
}
