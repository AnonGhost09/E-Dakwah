package com.myProject.dakwah.utils;

import com.myProject.dakwah.models.Report;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ToCsv {
    private final Path path;

    public ToCsv(String path) {
        try{
            this.path = Paths.get(path);
            boolean isNewFileExists = Files.exists(this.path);
            if(!isNewFileExists) Files.createFile(this.path);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void writeData(List<Report> content){
        try{
            for (Report report:
                   content) {
                Files.write(path,report.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getPath(){
        return path.toUri().getPath();
    }

}
