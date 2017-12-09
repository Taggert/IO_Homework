package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSearch implements Runnable {

    private String searchStr;
    private File file;
    private List<String> buff = new ArrayList<>();
    private String result;
    private Scanner searcher;
    public FileSearch(String searchStr, File file) {
        this.searchStr = searchStr;
        this.file = file;
    }


    private void search() throws IOException {
        try {
            searcher = new Scanner(file);
        } catch (FileNotFoundException e) {

        }
        while(searcher.hasNextLine()){
            buff.add(searcher.nextLine());
        }
        for (String str: buff) {
            if(str.contains(searchStr)){
                result = file.getCanonicalPath();
                synchronized (this) {
                    SearchStarter.res.add(result);
                }
            }
        }




    }

    @Override
    public void run() {
        try {
            search();
        } catch (IOException e) {

        }
    }

    public String getResult() {
        return result;
    }
}