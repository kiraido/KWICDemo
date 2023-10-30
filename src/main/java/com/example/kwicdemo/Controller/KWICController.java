package com.example.kwicdemo.Controller;

import com.example.kwicdemo.KWIC.demo1.demo1;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static com.example.kwicdemo.KWIC.demo2.Main.run2;
import static com.example.kwicdemo.KWIC.demo3.Main.run3;
import static com.example.kwicdemo.KWIC.demo4.Main.run4;

@RestController
public class KWICController {

    @PostMapping("/processFile")
    public ResponseEntity<String> processFile(MultipartFile file, int method) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Error: File is empty.");
        }

        try {
            File uploadedFile = convertMultipartFileToFile(file);
            String processedContent =
                    processFileContent(uploadedFile, method);
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(processedContent);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        Files.copy(file.getInputStream(), convertedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return convertedFile;
    }

    public static String ReadFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(demo1.run1(file)));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    private String processFileContent(File file, int method) throws IOException {
        String processedContent = null;

        switch (method) {
            case 1:
                // Process logic for method 1 and assign the result to processedContent
                processedContent = demo1.run1(file);
                break;
            case 2:
                // Process logic for method 2 and assign the result to processedContent
                processedContent = run2(file);
                break;
            case 3:
                // Process logic for method 3 and assign the result to processedContent
                processedContent = run3(file);
                break;
            case 4:
                // Process logic for method 4 and assign the result to processedContent
                processedContent = run4(file);
                break;
            default:
                // Unknown method
                return "Error: Unknown method";
        }

        return processedContent;
    }
}
