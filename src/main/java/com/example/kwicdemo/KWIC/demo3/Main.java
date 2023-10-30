package com.example.kwicdemo.KWIC.demo3;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ////创建主题
        //KWICSubject kwicSubject = new KWICSubject();
        ////创建观察者
        //Input input = new Input("C:\\Users\\lei kai\\Desktop\\KWIC\\1.txt");
        //Shift shift = new Shift(input.getLineTxt());
        //Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        //Output output = new Output(alphabetizer.getKwicList()
        //        , "C:\\Users\\lei kai\\Desktop\\KWIC\\4.txt");
        //
        //// 将观察者加入主题
        //kwicSubject.addObserver(input);
        //kwicSubject.addObserver(shift);
        //kwicSubject.addObserver(alphabetizer);
        //kwicSubject.addObserver(output);
        //// 逐步调用各个观察者
        //kwicSubject.startKWIC();
        //output.output("C:\\Users\\lei kai\\Desktop\\KWIC\\4.txt");
    }

    public static String run3(File file) throws IOException {
        KWICSubject kwicSubject = new KWICSubject();
        Input input = new Input(file);
        Shift shift = new Shift(input.getLineTxt());
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        Output output = new Output(alphabetizer.getKwicList(), file);

        // 将观察者加入主题
        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);

        kwicSubject.startKWIC();

        return output.output();
    }
}

