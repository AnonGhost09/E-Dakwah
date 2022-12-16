package com.myProject.dakwah.utils;

import com.myProject.dakwah.models.ReportCount;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ToCsv<T> {
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

    public void writeData(List<T> content){
        try{
            Integer i = 0;
            for (T reportCount :
                   content) {
                if(i==0){
                    Files.write(path, reportCount.toString().getBytes(StandardCharsets.UTF_8));
                }else{
                    Files.write(path, reportCount.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
                i++;
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public String getPath(){
        return path.toUri().getPath();
    }

}
