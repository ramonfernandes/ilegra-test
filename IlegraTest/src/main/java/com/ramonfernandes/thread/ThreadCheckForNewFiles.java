package com.ramonfernandes.thread;

import java.io.IOException;
import java.nio.file.*;

public class ThreadCheckForNewFiles {
    private static final String SUBDIRECTORY_IN_FOLDER = System.getProperty("user.home") + "\\dir\\in";

    private static Runnable thread = new Runnable() {
        public void run() {
            while (true) {
                try {
                    WatchService watcher = FileSystems.getDefault().newWatchService();
                    Path path = Paths.get(SUBDIRECTORY_IN_FOLDER);
                    path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
                    WatchKey watchKey;
                    while ((watchKey = watcher.take()) != null) {
                        for (WatchEvent<?> event : watchKey.pollEvents()) {
                            ThreadReadFilesAndExecute.addToQueue(SUBDIRECTORY_IN_FOLDER + event.context());
                        }
                        watchKey.reset();
                    }
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
