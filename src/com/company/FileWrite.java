package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileWrite implements Runnable {
    private String adress;
    private InputStreamReader reader;
    private OutputStream output;
    private ArrayList<File> files;


    public FileWrite(String adress) {
        this.adress = adress;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void write() throws IOException {

        int count = 1;
        System.out.println("Input text (to finish type #)");
        reader = new InputStreamReader(System.in);
        files = new ArrayList<>();
        char symb;
        boolean openFlag = true;
        File a = new File(adress);
        a.mkdirs();

        do {
            File file = null;
            symb = (char) reader.read();


            if (symb != (char) '#') {
                if (openFlag) {
                    file = new File(adress + "\\file" + count + ".txt");
                    output = new FileOutputStream(file);
                    openFlag = false;
                }
                output.write(symb);
            }
            if (symb == '\n') {
                output.close();
                files.add(file);
                openFlag = true;
                count++;
            }

        } while (symb != (char) '#');
        output.close();

        return;

    }


    @Override
    public void run() {
        try {
            write();
        } catch (IOException e) {

        }
    }
}