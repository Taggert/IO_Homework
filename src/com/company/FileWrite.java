package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileWrite implements Runnable {
    private String adress;
    private BufferedReader reader;
    private PrintWriter pw;
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
        System.out.println("Input text (to finish type -1)");
        reader = new BufferedReader(new InputStreamReader(System.in));
        files = new ArrayList<>();
        String symb;
        boolean openFlag = true;
        File a = new File(adress);
        a.mkdirs();

        while(true){
            File file = null;
            symb = reader.readLine();
            if(symb.equals("-1")){
                break;
            }

            file = new File(adress + "\\file" + count + ".txt");
            output = new FileOutputStream(file);
            pw = new PrintWriter(output);
            openFlag = false;

            pw.write(symb);
            pw.flush();


            files.add(file);

            count++;


        }
        pw.close();
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