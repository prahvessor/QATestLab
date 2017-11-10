package com.qatestlab.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperator {

    // список напитков
    private List<String> listOfLines = new ArrayList<>();

    public FileOperator(String filePath) {

        try (BufferedReader input = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = input.readLine()) != null)
                setListOfLines(line);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void setListOfLines(String newLine) {
        listOfLines.add(newLine);
    }

    public List<String> getListOfLines() {
        return listOfLines;
    }
}