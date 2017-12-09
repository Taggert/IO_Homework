package com.company;

import com.company.utils.*;

import java.util.ArrayList;


public class Main {

    static InputOutput inputOutput = new ConsoleInputOutput();

    public static void main(String[] args) {
        ArrayList<Item> items = getItems();
        Menu menu = new Menu(items, inputOutput);
        menu.runMenu();
    }

    private static ArrayList<Item> getItems() {
        ArrayList<Item> res = new ArrayList<>();


        res.add(new WhriteStarter(inputOutput));
        res.add(new SearchStarter(inputOutput));
        res.add(new ExitItem(inputOutput));

        return res;
    }
}
