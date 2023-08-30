package org.example.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListName {
    final String nameFile = "src/main/resources/CityName.txt";

    public List<String> getListName() {
        return listName;
    }

    List<String> listName = new ArrayList<>();

    public void listNames() throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                listName.add(line.trim().toLowerCase());
            }
        }
    }


    public static void main(String[] args) throws IOException {
        ListName listName1 = new ListName();
        listName1.listNames();
    }
}
