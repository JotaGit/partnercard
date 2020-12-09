package com.embaixadaflaespanha.partnercard.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestUtils {
    public static String getResourceAsString(String resourcePath) {
        try {
            Path path = new ClassPathResource(resourcePath).getFile().toPath();
            return new String(Files.readAllBytes(path));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
