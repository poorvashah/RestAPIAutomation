package com.niit.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class JsonFileGenerator {

    public static String GenerateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
