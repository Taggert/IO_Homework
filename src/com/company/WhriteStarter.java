package com.company;

import com.company.utils.InputOutput;
import com.company.utils.Item;

import java.util.Scanner;

public class WhriteStarter extends Item {

    public WhriteStarter(InputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Create files";
    }

    @Override
    public void perform() {

        System.out.println("Input adress of the output folder in style(C:\\FolderName)");
        Scanner scan = new Scanner(System.in);
        String adress = scan.nextLine();

        FileWrite test = new FileWrite(adress);
        Thread writeThread = new Thread(test);
        writeThread.start();
        try {
            writeThread.join();
        } catch (InterruptedException e) {

        }


        System.out.println("Files saved");
    }
}