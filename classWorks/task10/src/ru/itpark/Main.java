package ru.itpark;

import java.io.*;

public class Main {

    public static String readNextLine (InputStream inputStream) {
        String string = "";

        try {
            int character = inputStream.read();

            while (character != '\n') {
                string += (char)character;
                character = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static void main(String[] args) {
        try {
            OutputStream outputStream =
                new FileOutputStream("output.txt");

            Rectangle a = new Rectangle("Rec1", 10, 2);
            Rectangle b = new Rectangle("Rec2", 2, 10);
            Triangle c = new Triangle("Triangle1", 5, 1, 2);
            Triangle d = new Triangle("Triangle2", 1, 1, 1);

            Figure figures[] = {a, b, c, d};

            for (int i = 0; i < figures.length; i++) {
                outputStream.write((figures[i].toString() + '\n').getBytes());
            }
            outputStream.close();

            InputStream inputStream = new FileInputStream("output.txt");
            System.out.println(readNextLine(inputStream));
            /*byte bytes[] = new byte[100];
            inputStream.read(bytes);

            String string = new String(bytes);
            System.out.println(string);*/
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }


    }
}
