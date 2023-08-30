package org.example.Utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ParserCityJSON {

    public static void main(String[] args) {
        try {
            JsonArray jsonArray = JsonParser.parseReader(new InputStreamReader(new FileInputStream("src/main/resources/City.json"), StandardCharsets.UTF_8)).getAsJsonArray();

            FileWriter fileWriter = new FileWriter("CityName.txt", StandardCharsets.UTF_8);

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();

                String objectName = jsonObject.get("object_name").getAsString();

                fileWriter.write(objectName.toLowerCase() + "\n");
            }

            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
