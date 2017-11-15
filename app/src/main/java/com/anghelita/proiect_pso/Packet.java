package com.anghelita.proiect_pso;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

/**
 * Created by c1baN on 11/15/2017.
 */

public class Packet {
    public static void Send(HttpURLConnection httpURLConnection, String data) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(outputStream,
                "UTF-8"));
        bufferedWriter.write(data);
//        bufferedWriter.flush();
//        bufferedWriter.close();
    }

    public static String Recieve(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String json_string;
        StringBuilder stringBuilder = new StringBuilder();
        while ((json_string = bufferedReader.readLine()) != null) {
            stringBuilder.append(json_string + "\n");
        }
        inputStream.close();
        return stringBuilder.toString().trim();
    }
}
