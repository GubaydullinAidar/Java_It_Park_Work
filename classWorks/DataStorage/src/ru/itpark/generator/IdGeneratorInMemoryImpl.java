package ru.itpark.generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IdGeneratorInMemoryImpl implements IdGenerator {
    private int lastGeneratedId;
    public String fileName;

    public IdGeneratorInMemoryImpl() {
        lastGeneratedId = findLastId("humans.txt");
    }

    @Override
    public int nextId() {
        lastGeneratedId = lastGeneratedId + 1;
        return lastGeneratedId;
    }

    public int findLastId(String filename) {

        try {
        BufferedReader reader =
            new BufferedReader(new FileReader(fileName));
        String currentHumanAsString = reader.readLine();
            while (currentHumanAsString != null) {
                String currentHumanAsStringArray[]
                        = currentHumanAsString.split(" ");
            }
            return Integer.parseInt(currentHumanAsStringArray[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
            }
    }
}