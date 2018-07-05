package com.ramonfernandes.filereader;

import java.io.File;

public class InternalFolderReader {

    private InternalFileReader internalFileReader;

    public InternalFolderReader(){
        internalFileReader = new InternalFileReader();
    }

    public void getNewFilesOnFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            System.out.println(folder.getName() + fileEntry);
        }
    }

    public String transformIntoValiableDirectoryFormat(String directory){
        return directory.replace("/", "\\\\");
    }
}
