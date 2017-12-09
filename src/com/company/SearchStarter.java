package com.company;

import com.company.utils.InputOutput;
import com.company.utils.Item;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SearchStarter extends Item {
    public static volatile List<String> res;

    public SearchStarter(InputOutput inputOutput) {
        super(inputOutput);
    }

    @Override
    public String displayedName() {
        return "Search in files";
    }

    @Override
    public void perform() {
        res = new ArrayList<>();
        System.out.println("Input path to the foledr with files.");
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        File dir = new File(path);
        List<File> files = Arrays.asList(dir.listFiles());
        System.out.println("Input string to search.");
        String searchStr = scan.nextLine();
        List<Thread> searchThreads = new ArrayList<>();
        for (int i = 0; i < files.size() ; i++) {
            Thread thread = new Thread(new FileSearch(searchStr, files.get(i)));
            searchThreads.add(thread);
        }
        for (Thread thread: searchThreads) {
            thread.start();
        }
        for (Thread thread: searchThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }
        System.out.println("\n===Search results===");
        res.forEach(System.out::println);
        System.out.println("====================\n");

    }
}