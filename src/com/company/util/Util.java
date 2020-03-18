package com.company.util;

import java.io.File;
import java.io.IOException;

public class Util {

    public static File programFile;


    public static File directory(File dir,String programName) {
        if(programFile!=null){
            return programFile;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
            if(file.getName().equals(programName + ".exe")){
                programFile=file;
                return programFile;
            }
            if (file.listFiles() != null)
                directory(file,programName);
        }
        return programFile;
    }

}
