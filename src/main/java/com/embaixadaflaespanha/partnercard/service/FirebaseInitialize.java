package com.embaixadaflaespanha.partnercard.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseInitialize {

    @Value("${application.firebase.credentials.jsonpath}")
    private String credentialsJsonPath;

    @Value("${application.firebase.credentials.database-url}")
    private String databaseUrl;

    @PostConstruct
    public void initialize() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream(credentialsJsonPath);

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(databaseUrl)
                .build();

        FirebaseApp.initializeApp(options);
    }
}