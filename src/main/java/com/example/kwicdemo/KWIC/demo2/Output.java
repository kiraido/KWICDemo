package com.example.kwicdemo.KWIC.demo2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    private ArrayList<String> kwicList;


    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public String output() {
        Iterator<String> it = kwicList.iterator();
        StringBuilder fileContent = new StringBuilder();

        while (it.hasNext()) {
            fileContent.append(it.next()).append("\n");
        }

        return fileContent.toString();
    }

}

