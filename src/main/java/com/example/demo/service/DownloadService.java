package com.example.demo.service;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

@Component
public class DownloadService {

    public void download() {
        try {
            URL nexus = new URL("http://localhost:8081/repository/maven-public/org/sonatype/nexus/examples/simple-project/1.0.0-SNAPSHOT/simple-project-1.0.0-20220531.120641-1.jar");

            String passwdstring = "admin:admin123";
            String encoding = new sun.misc.BASE64Encoder().encode(passwdstring.getBytes());

            URLConnection uc = nexus.openConnection();
            uc.setRequestProperty("Authorization", "Basic " + encoding);
            uc.setRequestProperty("Accept", "application/json");

            InputStream content = uc.getInputStream();
            OutputStream os = new FileOutputStream("D:\\download\\app.jar");

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = content.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            content.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
