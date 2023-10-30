package com.example.kwicdemo;

import com.example.kwicdemo.KWIC.demo1.demo1;
import com.example.kwicdemo.KWIC.demo2.Main;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static com.example.kwicdemo.Controller.KWICController.ReadFile;

@SpringBootTest
class KwicDemoApplicationTests {

	@Test
	void contextLoads() throws IOException {
		String run = demo1.run1(new File("1.txt"));
		System.out.println(run);
	}


}
