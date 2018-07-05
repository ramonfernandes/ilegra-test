package com.ramonfernandes.main;

import com.ramonfernandes.filereader.InternalFileReader;

import java.io.File;

public class Main {
    private static final String SUBDIRECTORY_IN_FOLDER = "\\dir\\in";

    public static void main(String[] args){
        InternalFileReader internalFileReader = InternalFileReader.getInstanceOf();
        File folder = new File(System.getProperty("user.home") + SUBDIRECTORY_IN_FOLDER);
        internalFileReader.getNewFilesOnFolder(folder);
    }
}
