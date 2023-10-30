package com.example.kwicdemo.KWIC.demo3;

import java.io.IOException;

public class KWICSubject extends Subject{
    public void startKWIC() throws IOException {
        for (int i = 0;i<3;i++){
            super.notifyOneObserver(i);
        }
    }
}
