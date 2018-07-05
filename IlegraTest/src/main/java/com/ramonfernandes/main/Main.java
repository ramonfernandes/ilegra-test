package com.ramonfernandes.main;

import com.ramonfernandes.filereader.InternalFolderReader;

import java.io.File;

public class Main {
    private static final String SUBDIRECTORY_IN_FOLDER = "\\dir\\in";

    public static void main(String[] args){
        InternalFolderReader internalFolderReader = new InternalFolderReader();
        File folder = new File(System.getProperty("user.home") + SUBDIRECTORY_IN_FOLDER);
        boolean directory = folder.isDirectory();
        internalFolderReader.getNewFilesOnFolder(folder);
    }
}
