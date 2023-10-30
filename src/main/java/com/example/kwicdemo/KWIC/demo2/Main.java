package com.example.kwicdemo.KWIC.demo2;

import com.example.kwicdemo.KWIC.demo1.demo1;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        //Input input = new Input();
        //input.input("C:\\Users\\lei kai\\Desktop\\KWIC\\1.txt");
        //Shift shift = new Shift(input.getLineTxt());
        //shift.shift();
        //Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        //alphabetizer.sort();
        //Output output = new Output(alphabetizer.getKwicList());
        //output.output("C:\\Users\\lei kai\\Desktop\\KWIC\\3.txt");

    }

    public static String run2(File file) throws IOException {
        Input input = new Input();
        input.input(file);
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        return output.output();
    }
}

